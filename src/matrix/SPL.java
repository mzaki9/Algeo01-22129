package matrix;

import iomatrix.OutputMatrix;

public class SPL {

    

    

    public static void OBEBarisPlusMinusFaseMaju(Matrix m, int i1, int j1, int i2) {
        // kurangi seluruh baris i1 dengan i2, dengan konstanta key1/key2 dengan key
        // dari i1 dan j1
        // boolean arah, bila false maka kurangi untuk eliminasi gauss, bila true maka
        // untuk gaussjordan
        // prekondisi : apabila ingin gaussjordan, harus di gauss dulu
        double key1 = m.getElmt(i1, j1);

        while (m.getElmt(i2, j1) == 0 && i2 > 0) {
            i2--;
        }

        // sekarang i2 pasti dapat sebagai index yang memiliki elemen bukan 0 ATAU i2 =
        // 0, karena i2 tidak mungkin -1
        double key2 = m.getElmt(i2, j1);
        if (key2 == 0) {
            // handler error
            key2 = 1;
        }

        double cons = Math.abs((key1 / key2));

        for (int k = j1; k < m.getColEff(); k++) {
            if ((key1 > 0 && key2 < 0) || (key1 < 0 && key2 > 0)) {

                double increment = (m.getElmt(i1, k) + (cons * m.getElmt(i2, k)));
                // System.out.println(m.getElmt(i1, k) + " + (" + cons + "*" + m.getElmt(i2,
                // k)+")");

                m.setElmt(i1, k, increment);
            } else {
                // NANTI UNTUK KONVERSI INI AKAN DIBUAT FUNGSI PEMBANTU MISALNYA :
                // doubleToString, stringToDouble, untuk sekarang seperti ini dulu
                double increment = (m.getElmt(i1, k) - (cons * m.getElmt(i2, k)));
                // System.out.println(m.getElmt(i1, k) + " - (" + cons + "*" + m.getElmt(i2,
                // k)+")");
                m.setElmt(i1, k, increment);
            }

        }

    }

    

    public static Matrix createMatriksEselon(Matrix m) {
        // Prekondisi: tidak ada 1 kolom yang 0 semua / koefisien trash
        // Pengecekan apabila baris ke-1 0 atau 1 bukan
        int i = 0;
        int i1 = 0;
        while (i1 < m.getRowEff() && m.getElmt(i1, 0) != 1) {
            i1++;
        }
        while (i < m.getRowEff() && m.getElmt(i, 0) == 0) {
            i++;
        }
        if (i != m.getRowEff()) {
            Tools.swapBaris(m, 0, i);
        }

        if (i1 != m.getRowEff() && m.getElmt(0, 0) != 1) {
            Tools.swapBaris(m, 0, i1);
        }

        Tools.buat1Utama(m, 0);

        int batasAugmented = m.getColEff() - 1;
        int k = 1;
        // Mulai algoritma Gauss
        for (int j = 0; j < batasAugmented; j++) {
            for (i = 1 + j; i < m.getRowEff(); i++) {
                if (Tools.cekBarisUnik(m, i) == false) {
                    OBEBarisPlusMinusFaseMaju(m, i, j, j);
                }
            }
            if (k < m.getRowEff()) {
                Tools.buat1Utama(m, k);
            }
            k++;
        }
        // Kalau ada yang sama barisnya, dibuat 0 slaah satu, untuk mempermudah
        // perhitungan nantinya
        Tools.delBarisSama(m);
        return m;

    }

    public static boolean cekKolom0(Matrix m, int col) {
        int flag = 0;
        for (int i = 0; i < m.getRowEff(); i++) {
            if (m.getElmt(i, col) == 0) {
                flag++;
            }

        }
        return (flag == m.getRowEff() - 1);
    }

    public static void createEselonTereduksi(Matrix m) {
        // Prekondisi : Harus di eselon baris dulu matrkisnya

        int k;
        int j1utama = 0;
        int batasAugmented = m.getColEff() - 1;
        for (int i = 1; i < m.getRowEff(); i++) {
            // Untuk mendapatkan 1 utama berada di kolom berapa
            j1utama = 0;
            while (m.getElmt(i, j1utama) != 1 && j1utama < batasAugmented) {
                j1utama++;
            }
            if (j1utama == batasAugmented) {
                continue;
            }

            for (int i1utama = 0; i1utama < j1utama; i1utama++) {
                if (i1utama == m.getRowEff() - 1) {
                    break;
                }
                double cons = Math.abs(m.getElmt(i1utama, j1utama));
                double key = m.getElmt(i1utama, j1utama);

                for (k = 0; k < m.getColEff(); k++) {

                    if (key > 0) {
                        double hasil = m.getElmt(i1utama, k) - (cons * m.getElmt(i, k));
                        m.setElmt(i1utama, k, hasil);
                    } else// key negatif
                    {
                        double hasil = m.getElmt(i1utama, k) + (cons * m.getElmt(i, k));
                        m.setElmt(i1utama, k, hasil);
                    }

                }

            }

            // udah nemu 1 utama

        }

    }

    public static String[] solutionGaussJordan(Matrix m)
    // PREKONDSI : Matriks sudah berbentuk matriks eselon tereduksi
    // Menghasilkan matriks string yang berisi solusi
    {
        int j1utama;
        String[] ans = new String[m.getColEff() - 1];
        for (int k = 0; k < ans.length; k++) {
            ans[k] = "";
        }
        int batasAugmented = m.getColEff() - 1;
        for (int i = 0; i < m.getRowEff(); i++) {
            boolean cekb = false;
            j1utama = 0;

            // Mencari kolom dari 1 utama
            while (m.getElmt(i, j1utama) != 1 && j1utama < batasAugmented) {
                j1utama++;
            }
            if (j1utama != batasAugmented) {
                for (int j = 0; j < batasAugmented; j++) {

                    // apabila ditemukan 0 dan kolom j tidak sama dengan kolom j1utama, ATAU j1utama
                    // berada di akhir
                    if (j != j1utama && m.getElmt(i, j) != 0 || Tools.cekBarisUnik(m, i)) {

                        if (!(Tools.cekBarisUnik(m, i))) {
                            if ((-1) * m.getElmt(i, j) > 0) {
                                if (ans[j1utama] != "") {
                                    ans[j1utama] += "+ ";
                                }
                                ans[j1utama] += Double.toString((-1) * m.getElmt(i, j)) + "R" + Integer.toString(j + 1)
                                        + " ";
                            } else {
                                ans[j1utama] += "- " + Double.toString(m.getElmt(i, j)) + "R" + Integer.toString(j + 1)
                                        + " ";
                            }
                        }

                        // Memasukkan nilai b di akhir persamaan
                        if (m.getElmt(i, batasAugmented) > 0 && cekb == false && j == batasAugmented - 1) // j ==
                                                                                                          // batasaugmented
                                                                                                          // - 1 agar
                                                                                                          // penempatan
                                                                                                          // si B di
                                                                                                          // akhir
                                                                                                          // persamaan.
                        {
                            if (ans[j1utama] != "") {
                                ans[j1utama] += "+ ";
                            }
                            ans[j1utama] += Double.toString(m.getElmt(i, batasAugmented));
                            cekb = true;
                        } else if (m.getElmt(i, batasAugmented) < 0 && cekb == false && j == batasAugmented - 1)// apabila
                                                                                                                // b di
                                                                                                                // akhir
                                                                                                                // negatif
                        {
                            if (ans[j1utama] != "") {
                                ans[j1utama] += "";
                            }
                            ans[j1utama] += Double.toString(m.getElmt(i, batasAugmented));
                            cekb = true;
                        }

                    }
                }

            }
        }
        return ans;
    }

    

    public static Matrix inverseMatrix(Matrix m) {
        int n = m.getRowEff();

        if (/* m.getColEff() - 1 != m.getRowEff() */ Kofaktor.hitungDeterminan(m) == 0) {
            System.out.println("Matrix tidak valid / atau tidak memiliki solusi unik");
            return null;
        }

        Matrix matrixTanpaB = new Matrix(n, n);
        Matrix b = Tools.extractB(m);
        Matrix hasil = new Matrix(m.getRowEff(), m.getRowEff());
        Matrix x = new Matrix(hasil.getRowEff(), 1);

        matrixTanpaB = Tools.matrixWithoutB(m);
        hasil = MatrixBalikan.GaussJordan(matrixTanpaB);
        if (hasil != null) {
            // X = hasil^-1 * b
            for (int i = 0; i < hasil.getRowEff(); i++) {
                double sum = 0.0;
                for (int j = 0; j < hasil.getColEff(); j++) {
                    sum += hasil.getElmt(i, j) * b.getElmt(j, 0);
                }
                x.setElmt(i, 0, sum);
            }

            OutputMatrix.tulisSolusi(x);
        } else {
            return null;
        }

        return x;

    }

    public static Matrix Cramer(Matrix m, Boolean isInterpolasi) {

        // Check Cramer
        if (m.getRowEff() == m.getColEff()) {
            System.out.println("Matrix tidak valid");
            return null;
        }

        Matrix matrix = null;

        Matrix b = Tools.extractB(m); // Ambil "b" dari matrix original

        matrix = Tools.matrixWithoutB(m);
        // Tools.copyMatrix(matrixWithoutB(m), matrix);

        double determinan = Kofaktor.hitungDeterminan(matrix);
        if (determinan == 0) {
            System.out.println("Determinan matriks adalah nol, tidak ada solusi atau solusi tidak unik.");
            return null;
        }

        Matrix temp = new Matrix(m.getRowEff(), m.getColEff());
        Matrix x = new Matrix(matrix.getColEff(), 1); // matrix ini dibuat untuk menyimpan hasil x

        // Mulai Cramer
        for (int i = 0; i < matrix.getColEff(); i++) {
            Tools.copyMatrix(matrix, temp);
            for (int j = 0; j < matrix.getRowEff(); j++) {
                temp.setElmt(j, i, b.getElmt(j, 0));
            }
            x.setElmt(i, 0, Kofaktor.hitungDeterminan(temp) / determinan);
        }

        return x;
    }

   

    

}
