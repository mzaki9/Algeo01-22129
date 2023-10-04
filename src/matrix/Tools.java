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
}
