package iomatriks;

import java.io.*;
import java.util.Scanner;

public class InputMatriks {

    public static double[][] inputMatriksKeyboard(Scanner scanner) {
        double[][] matrix = null;
        int row, col;

        row = 0;
        col = 0;

        
        // Input Jumlah Kolom dan baris
        System.out.println("Masukkan jumlah baris: ");
        row = scanner.nextInt();

        // Pastikan jumlah baris >= 0
        while (row < 0) {
            System.out.println("Jumlah baris harus lebih besar sama dengan 0. Masukkan jumlah baris yang valid: ");
            row = scanner.nextInt();
        }

        System.out.println("Masukkan jumlah kolom: ");
        col = scanner.nextInt();

        // Pastikan jumlah kolom >= 0
        while (col < 0) {
            System.out.println("Jumlah kolom harus lebih besar sama dengan 0. Masukkan jumlah kolom yang valid: ");
            col = scanner.nextInt();
        }

        matrix = new double[row][col];

        // Input elemen pada matrix
        System.out.println("Masukkan elemen pada matriks: ");
        for (int i = 0; i < row; i++) {
            {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = scanner.nextDouble();
                }
            }
        }
        return matrix;
    }

    public static double[][] inputFileMatriks(String filename, Scanner scanner) {
        double[][] matrix = null;
        String filePath = "../test/" + filename + ".txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int RowEff = 0;
            int ColEff = 0;
            // Dapetin jumlah RowEff dan ColEff dari file txt
            while ((line = reader.readLine()) != null) {
                // RowEff + 1 tiap dibaca line baru
                RowEff++;

                String[] elements = line.split(" ");
                // Panjang array elements menunjukkan banyaknya column
                ColEff = elements.length;

            }

            matrix = new double[RowEff][ColEff];
            reader.close();
            // isi ulang
            int i = 0;
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(" ");
                for (int j = 0; j < elements.length; j++) {
                    matrix[i][j] = Double.parseDouble(elements[j]);
                }
                i++;
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("========================================================");
            System.out.println("ERROR! File tidak ditemukan, keluar program! (for now)");
            System.out.println("========================================================");

        }

        return matrix;

    }


    public static double[][] inputNamaFileMatriks(Scanner scanner) {

        System.out.print("masukkan nama file txt:  ");
        String namafile = scanner.nextLine();

        return inputFileMatriks(namafile, scanner);
    }

}
