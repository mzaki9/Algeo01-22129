package iomatrix;
import java.io.*;
import javax.swing.JOptionPane;
import matrix.Matrix;
import matrix.Tools;


public class OutputMatrix {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void tulisMatrix(Matrix M) {
        for (int i = 0; i < M.getRowEff(); i++) {
            for (int j = 0; j < M.getColEff(); j++) {
                System.out.print(M.getElmt(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static String tulisSolusiGaussJordan(String[] ans, Matrix m) {
        String s = "";
        if (Tools.cekNoSolution(m) || Tools.Same1Utama(m)) {
            System.out.println("Tidak ada solusi!");
            s+="Tidak ada solusi!";
        } else {
            System.out.println("=============SOLUSI===============");
            s+="=============SOLUSI===============\n";
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] != "") {
                    System.out.println("X" + (i + 1) + " =" + " " + ans[i]);
                    s+= "X" + (i + 1) + " =" + " " + ans[i] + "\n";
                } else {
                    System.out.println("X" + (i + 1) + " = " + "R" + (i + 1) + " - isi bebas ");
                    s += "X" + (i + 1) + " = " + "R" + (i + 1) + " - isi bebas \n";
                }
            }
            System.out.println("===================================");
            s+= "===================================\n";

        }   
        return s;
    }

    public static void tulisSolusi(Matrix x) {

        System.out.println("Solusi Sistem Persamaan Linear:");
        for (int i = 0; i < x.getRowEff(); i++) {
            System.out.printf("x%d = %f\n", (i + 1), x.getElmt(i, 0));
        }
    }

    public static String dir = "../test";
    public static String path = "";

    public static void createFile() {
        try {
            pathMaker();
            System.out.println("Masukkan nama file: ");
            String name = reader.readLine();
            File file = new File(dir + name);
            if (!file.exists()) {
                file.createNewFile();
            }
            path = file.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("Terjadi error.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

    public static String matrixToString(Matrix M) {
        String s = "";
        for (int i = 0; i < M.getRowEff(); i++) {
            for (int j = 0; j < M.getColEff(); j++) {
                if (j == M.getColEff()) {
                    s += M.getElmt(i, j);
                } else {
                    s += M.getElmt(i, j) + " ";
                }
            }
            s += "\n";
        }
        return s;
    }

    public static void pathMaker() {
        String directory = System.getProperty("user.dir");
        directory = directory.substring(directory.lastIndexOf("\\") + 1);
        if (directory.equals("bin")) {
            dir = "..\\test\\";
        } else {
            dir = "test\\";
        }
    }

    public static void TuliskeTxt(String s) {
        try {
            createFile();
            FileWriter wr = new FileWriter(path);
            wr.write(s);
            wr.close();
            System.out.println("Sukses menulis file.");
        } catch (IOException e) {
            System.out.println("Terjadi error.");

        }
    }

    public static void tulisSolusiInterpolasiP(Matrix m) {
        int n = m.getRowEff() - 1; // Derajat polinomial interpolasi

        System.out.print("P" + n + "(x) = ");

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print(String.format("%.3f", m.getElmt(i, 0)));
            } else {
                System.out.print(" + " + String.format("%.3f", m.getElmt(i, 0)) + "x^" + i);
            }
        }


        System.out.println(); // Baris baru setelah cetakan
    }

}
