package matrix;
import iomatrix.*;
import java.util.Scanner;
public class Kofaktor {
   
    // Fungsi untuk menghitung determinan matrix
    public static double hitungDeterminan(Matrix matrix) {
        int n = matrix.getRowEff();

        // Basis kasus: Matrix 1x1
        if (n == 1) {
            return matrix.getElmt(0,0);
        }

        double determinan = 0;

        // Iterasi melalui baris pertama untuk menghitung ekspansi kofaktor
        for (int i = 0; i < n; i++) {
            // Menghitung kofaktor matrix[0][i]
            double kofaktor = matrix.getElmt(0,i) * hitungDeterminan(getSubMatrix(matrix, 0, i));
            
            // Tambah atau kurangkan kofaktor ke determinan tergantung pada indeks baris
            if (i % 2 == 0) {
                determinan += kofaktor;
            } else {
                determinan -= kofaktor;
            }
        }

        return determinan;
    }

    // Fungsi untuk mengambil submatrix tanpa baris dan kolom tertentu
    public static Matrix getSubMatrix(Matrix matrix, int row, int col) {
        int n = matrix.getRowEff();
        Matrix subMatrix = new Matrix(n-1,n-1);
        int newRow = 0, newCol = 0;

        for (int i = 0; i < n; i++) {
            if (i == row) continue;

            for (int j = 0; j < n; j++) {
                if (j == col) continue;

                subMatrix.setElmt(newRow, newCol, matrix.getElmt(i, j));
                newCol++;
            }

            newRow++;
            newCol = 0;
        }

        return subMatrix;
    }


    public static Matrix MatrixKofaktor(Matrix matrix){
        int n=matrix.getRowEff();
        Matrix matkof = new Matrix(n,n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            // Menghitung kofaktor matrix[i][j]
            double kofaktor = hitungDeterminan(getSubMatrix(matrix, i,j));
            
            if ((i+j) % 2 == 1) {
                kofaktor*=-1;
            }
            matkof.setElmt(i, j, kofaktor); 
        }
    }
        return matkof;
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

    public static Matrix DividebyCons(Matrix matrix, double x){
        for (int i = 0; i < matrix.getRowEff(); i++) {
            for (int j = 0; j < matrix.getColEff(); j++) {
                matrix.setElmt(i,j, matrix.getElmt(i, j)/x);
            }
        }
            
        return matrix;
    }

    public static Matrix InverseKofaktor(Matrix matrix) {
        int n = matrix.getRowEff();
        Matrix inverse = new Matrix(n,n), adjoin=new Matrix(n,n);
        double det = hitungDeterminan(matrix);
        adjoin=Transpose(MatrixKofaktor(matrix));
        inverse=DividebyCons(adjoin,det);
        return inverse;
    }

    public static void TulisInverse(Matrix matrix){
            System.out.println("Inversenya adalah: ");
            OutputMatrix.tulisMatrix(matrix);    
    }

    public static void TulisDetKofaktor(Double x) {
            System.out.println("Determinannya adalah: " + x);  
    }

// // Test
//     public static void main(String[] args){
//         double[][] matrix = {
//             {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
//             {1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
//             {1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0},
//             {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
//             {0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
//             {0.0, 1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
//             {0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0},
//             {0.0, 1.0, 2.0, 3.0, 0.0, 1.0, 2.0, 3.0, 0.0, 1.0, 2.0, 3.0, 0.0, 1.0, 2.0, 3.0},
//             {0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
//             {0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
//             {0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 2.0, 0.0, 0.0, 0.0, 3.0, 0.0, 0.0, 0.0},
//             {0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0, 3.0},
//             {0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
//             {0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
//             {0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 2.0, 0.0, 0.0, 0.0, 3.0, 0.0, 0.0},
//             {0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 2.0, 3.0, 0.0, 2.0, 4.0, 6.0, 0.0, 3.0, 6.0, 9.0}
//         };
//         Matrix mat = new Matrix(16,16), inverse=new Matrix(16,16);
//         for (int i=0; i<16; i++){
//             for (int j=0; j<16; j++){
//                 mat.setElmt(i, j, matrix[i][j]);
//             }
//         }
//         inverse=InverseKofaktor(mat);

//         for (int i=0; i<16; i++){
//             for (int j=0; j<16; j++){
//                 System.out.print(inverse.getElmt(i, j)+" ");
//             }
//             System.out.print("\n");
//         }
//         System.out.println(hitungDeterminan(mat));
//     }
}