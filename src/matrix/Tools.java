package matrix;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Tools 
{
    public static Matrix konversiFloattoDouble(Matrix m )
    //Gunakan di akhir, saat ingin menunjukkan matriks, takutnya mengubah nilai float to double di tengah operasi, nanti jadi gak akurat hasilnya
    //INGAT, kalau pake tulisMatriks trus konversi, nanti bisa bisa ke bulet terus, karena tulisMatriks itu prosedural, jadi lebih baik gunakan fungsi ini diakhir proses!!
    {
        for (int i = 0; i < m.getRowEff(); i++) {
            for (int j = 0; j < m.getColEff(); j++) {
                    double increment = m.getElmt(i, j);
                    DecimalFormat df = new DecimalFormat("#.##");
                    String hasil = df.format(increment);
                    double nilaiBulat = Double.parseDouble(hasil);
                    m.setElmt(i, j, nilaiBulat);

            }
        }
        return m;
    }

    public static void copyMatrix(Matrix ref,Matrix dest){
        //Prekondisi Ukuran matrix sama
        for (int i = 0; i < ref.getRowEff(); i++) {
            for (int j = 0; j < ref.getColEff(); j++) {
                dest.setElmt(i, j, ref.getElmt(i, j));
            }
        }
    }

    public static Matrix multiplyMatrix(Matrix matrix,Matrix b){
        Matrix x = new Matrix(matrix.getRowEff(), b.getColEff());
        double sum=0.0;
        for (int i = 0; i < matrix.getRowEff(); i++) {
            for (int j = 0; j < b.getColEff(); j++) {
                sum = 0.0;
                for (int k = 0; k < matrix.getColEff();k++)
                {sum += matrix.getElmt(i, k) * b.getElmt(k,j);}
                x.setElmt(i, j, sum);
            }
            
        }

        return x;
    }
    public static void kirimOpsiMethod()
    {
        System.out.println("OPSI METODE");
        System.out.println("1.Metode Eliminasi Gauss");
        System.out.println("2.Metode Eliminasi Gauss-Jordan");
        System.out.println("3.Matriks Metode matriks balikan");
        System.out.println("4.Kaidah Cramer");
        System.out.println("5.BALIK KE MENU");

    }

    public static void pause() {
            System.out.println("\nTekan apapun untuk melanjutkan...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
    }
    public static void kirimOpsiSimpan(){
        System.out.println("Apakah jawaban mau disimpan?");
        System.out.println("1.iya");
        System.out.println("2.tidak");
    }

    public static boolean checkSquare(Matrix m){
        if(m.getColEff() == m.getRowEff()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean cekNoSolution(Matrix m)
    // Cek apabila ditemukan pola tak ada solusi (di baris i semua 0 kecuali di
    // kolomn akhir)
    /*
     * contoh 1 2 2 3
     * 0 1 5 4
     * 0 0 0 1
     */
    {
        int j;

        for (int i = 0; i < m.getRowEff(); i++) {

            j = m.getColEff() - 2;
            while (j >= 0 && m.getElmt(i, j) == 0) {
                j--;
            }
            if (j == -1 && m.getElmt(i, m.getColEff() - 1) != 0) {
                return true;
            }
        }
        return false;

    }

    public static Matrix extractB(Matrix m) {
        // Function ini mengambil nilai "b" dari matrix

        Matrix b = new Matrix(m.getRowEff(), 1);
        // Ambil "b" dari matrix original
        for (int i = 0; i < m.getRowEff(); i++) {
            double bValue = m.getElmt(i, m.getColEff() - 1);
            b.setElmt(i, 0, bValue);
        }

        return b;
    }

    public static Matrix matrixWithoutB(Matrix m) {
        // Function ini tidak mengambil nilali "b" dari matrix original

        Matrix matrixTanpaB = new Matrix(m.getRowEff(), m.getColEff() - 1);
        for (int i = 0; i < m.getRowEff(); i++) {
            for (int j = 0; j < m.getColEff() - 1; j++) {
                matrixTanpaB.setElmt(i, j, m.getElmt(i, j));
            }
        }

        return matrixTanpaB;
    }
    public static void buat1Utama(Matrix m, int row)
    // Menerima 1 baris dalam matrix, dan tentukan 1 utama serta dibagi dalam kolom
    // "row tsb.
    // Prekondisi : matrix sudah di cek apabila fungsi noSolution = false
    {
        int k = 0;
        while (m.getElmt(row, k) == 0 && k < m.getColEff() - 1) {
            k++;
        }
        double cons = m.getElmt(row, k);
        if (m.getElmt(row, k) != 1 && cons != 0) {
            for (int i = k; i < m.getColEff(); i++) {
                double increment = m.Matrix[row][i] / cons;
                m.Matrix[row][i] = increment;
            }
        }

        // mungkin dikanan nya ada nilai bukan 0

    }
    public static void swapBaris(Matrix m, int i1, int i2)
    // Prosedur menukar nilai baris i1 dengan i2, i2 menjadi i1
    {
        double temp;

        for (int j = 0; j < m.getColEff(); j++) {
            temp = m.getElmt(i1, j);
            m.setElmt(i1, j, (m.getElmt(i2, j)));
            m.setElmt(i2, j, (temp));
        }
    }
    public static boolean Same1Utama(Matrix m) {
        // Mengembalikan nilai TRUE apabila ditemukan 1 utama yang lebih dari 1 dalam 1
        // kolom(berarti tidak ada solusi)

        boolean cek;
        for (int j = 0; j < m.getColEff() - 1; j++) {

            cek = false;
            for (int i = 0; i < m.getRowEff(); i++) {
                // cek 1 utama
                if (m.getElmt(i, j) == 1 && cek == false) {
                    cek = true;
                } else if (m.getElmt(i, j) == 1 && cek == true) {
                    return true;
                }
            }
        }
        return false;
        

    }
   
    public static boolean cekSolusiBanyak(Matrix m)
    // Return true apabila ditemukan 1 baris berisi 0 semua
    {
        int count;
        for (int i = 0; i < m.getRowEff(); i++) {
            count = 0;
            for (int j = 0; j < m.getColEff(); j++) {
                if (m.getElmt(i, j) == 0) {
                    count++;
                }
            }
            if (count == m.getColEff()) {
                return true;
            }
        }
        return false;

    }
    public static int getBarisSama(Matrix m, int row)
    // Mengembalikan baris ke berapa yang isi elemen sama persis dengan baris "row"
    // Bila tidak ditemukan, return baris yang sama dengan row
    {
        int count;
        for (int i = 0; i < m.getRowEff(); i++) {
            count = 0;
            for (int j = 0; j < m.getColEff(); j++) {
                if (m.getElmt(i, j) == m.getElmt(row, j) && row != i) {
                    count++;
                }
            }
            if (count == m.getColEff()) {
                return i;
            }
        }
        return row;
    }
    public static void delBarisSama(Matrix m)
    // baris yang diketahui sama, salah satu nya dibuat jadi 0
    {
        for (int i = 0; i < m.getRowEff(); i++) {
            if (getBarisSama(m, i) != i) {
                for (int j = 0; j < m.getColEff(); j++) {

                    m.setElmt(i, j, 0);

                }
            }
        }
    }
    public static boolean cekBarisUnik(Matrix m, int row)
    // mengembalikan nilai true apabila baris itu hasil unik / koefisien 1
    {
        int count = 0;
        for (int j = 0; j < m.getColEff() - 1; j++) {
            if (m.getElmt(row, j) == 0) {
                count++;
            }
        }
        return (count == m.getColEff() - 2);
    }
    public static boolean isMatrixSquare(Matrix m)
    //Mengembalikan TRUE apabila matriks berbentuk kotak(row=eff)
    {
        return (m.getColEff() == m.getRowEff());
    }

    public static double getElmtDiagonal(Matrix m , int i)
    //Mengembalikan nilai elemen diagonal dari matriks m
    {
        return m.getElmt(i,i);
    }

    public static Matrix DividebyCons(Matrix matrix, double x){
        for (int i = 0; i < matrix.getRowEff(); i++) {
            for (int j = 0; j < matrix.getColEff(); j++) {
                matrix.setElmt(i,j, matrix.getElmt(i, j)/x);
            }
        }
            
        return matrix;
    }

    public static Matrix Transpose(Matrix matrix){
        int n=matrix.getRowEff();
        Matrix Transpose = new Matrix(n,n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Transpose.setElmt(j, i, matrix.getElmt(i, j));
            }
        }
        return Transpose;
    }
}
