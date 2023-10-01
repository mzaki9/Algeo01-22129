package matrix;
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
        for (int i = 0; i < matrix.getRowEff(); i++) {
            double sum = 0.0;
            for (int j = 0; j < matrix.getColEff(); j++) {
                sum += matrix.getElmt(i, j) * b.getElmt(j, 0);
            }
            x.setElmt(i, 0, sum);
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
    
}
