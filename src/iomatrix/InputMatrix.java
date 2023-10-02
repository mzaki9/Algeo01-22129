package iomatrix;

import java.io.*;
import java.util.Scanner;
import matrix.*;

public class InputMatrix {
    
    public static Matrix inputInterpolasi(Scanner scanner){
        System.out.print("Masukkan derajat interpolasi: ");
        int derajat = scanner.nextInt();
        Matrix dataXY = new Matrix(derajat + 1, 2);

        for(int i = 0; i <= derajat; i++){
            for(int j = 0; j < 2;j++){
                dataXY.setElmt(i, j, scanner.nextDouble());
            }
        }

        return dataXY;
    }
    public static Matrix  inputHilbert(Scanner scanner)
    {
        System.out.print("Masukkan nilai n :  ");
        int n = scanner.nextInt();
        Matrix hilb = new Matrix(n, n+1);
        hilb.setElmt(0, hilb.getColEff()-1, 1);
        for (int i = 0; i < hilb.getRowEff(); i++) {
            for (int j = 0; j < hilb.getColEff()-1; j++) {
                double hasil = (double) 1/((i+j)+ 1);
                hilb.setElmt(i, j,hasil );
            }
        }
        return hilb;
    }
    public static void inputRegresiLinierKeyboard(Scanner scanner)
    // I.S Menerima scanner 
    // F.S Mengembalikan matriks yang sudah diolah menjadi regresi 
    {
        System.out.print("Mau berapa banyak peubah(var x)? (n) : ");
        int n = scanner.nextInt();
        System.out.print("Mau ada berapa sampel?  (m): ");
        int m = scanner.nextInt();
        System.out.println("Matrix dengan " + (n+1) + " kolom ( banyaknya peubah : " + n  +" + 1 y di akhir) " + "dan " + m + " baris telah dibuat");
        System.out.println();
        Matrix matriksRegresi = new Matrix(m, n+1);
        System.out.println("input dengan format x1,x2,...xn,ym (diakhiri dengan nilai y pada sampel tersebut)");
        for(int i = 0; i < matriksRegresi.getRowEff(); i++)
        {
            
            System.out.println("Masukkan sampel ke - "+ (i+1) );
            for(int j = 0; j < matriksRegresi.getColEff();j++)
            {   
                matriksRegresi.setElmt(i, j, scanner.nextDouble());
            }
        }
        
        
        Matrix eEqualReg = new Matrix(matriksRegresi.getColEff(), matriksRegresi.getColEff() + 1);
        Tools.copyMatrix(RegresiLinierBerganda.regresiGanda(matriksRegresi), eEqualReg);
        eEqualReg.Matrix[0][0] = matriksRegresi.getRowEff();
        // OutputMatrix.tulisMatrix(eEqualReg);
        SPL.createMatriksEselon(eEqualReg);
        SPL.createEselonTereduksi(eEqualReg);
        OutputMatrix.tulisMatrix(eEqualReg);
        if(SPL.cekSolusiBanyak(eEqualReg) || SPL.cekNoSolution(eEqualReg) || SPL.Same1Utama(eEqualReg))
        {
            System.out.println("Tidak Ada Solusi!");
            if(SPL.cekSolusiBanyak(eEqualReg) || SPL.Same1Utama(eEqualReg))
            {
                System.out.println("Ditemukan 1 baris 0 semua,(Solusi Banyak)");
            }
        }
        else
        {

            Float[] ansTab =  RegresiLinierBerganda.tulisSolusiRegresi(SPL.solutionGaussJordan(eEqualReg), eEqualReg);
            System.out.println("Persamaan nya adalah : ");
            System.out.print("y = " + ansTab[0]);
            for (int i = 1; i < ansTab.length; i++) {
                if (ansTab[i] > 0)
                {
                    System.out.print(" + " );
                } 
                System.out.print(ansTab[i] + " x" + i + " ");
                
            }
            System.out.println("\nHampirannya berapa? ada " + n +" buah x : ");
            float hampy = 0;
            hampy += ansTab[0];
            for (int i = 1; i <= n; i++) {
                
                double x = scanner.nextDouble();
                hampy += (x * ansTab[i]);
            }
            System.out.println("Dan Hampirannya adalah y =  " + hampy);
        }
    




    }
    public static void inputRegresiLinierFile(Scanner scanner)
    {
        Matrix matrix = inputFileMatrix(scanner);
        Matrix matriksRegresi = new Matrix(matrix.getRowEff()-1, matrix.getColEff());
        //Copy Matrix input file ke matriksRegresi untuk pengolahan
        for (int i = 0; i < matriksRegresi.getRowEff(); i++) {
            for (int j = 0; j < matriksRegresi.getColEff(); j++) {
                matriksRegresi.setElmt(i, j, matrix.getElmt(i, j));
            }
        }
        Matrix eEqualReg = new Matrix(matriksRegresi.getColEff(), matriksRegresi.getColEff() + 1);
        Tools.copyMatrix(RegresiLinierBerganda.regresiGanda(matriksRegresi), eEqualReg);
        eEqualReg.Matrix[0][0] = matriksRegresi.getRowEff();
        // OutputMatrix.tulisMatrix(eEqualReg);
        SPL.createMatriksEselon(eEqualReg);
        SPL.createEselonTereduksi(eEqualReg);
        OutputMatrix.tulisMatrix(eEqualReg);
        if(SPL.cekSolusiBanyak(eEqualReg) || SPL.cekNoSolution(eEqualReg) || SPL.Same1Utama(eEqualReg))
        {
            System.out.println("Tidak Ada Solusi!");
            if(SPL.cekSolusiBanyak(eEqualReg) || SPL.Same1Utama(eEqualReg))
            {
                System.out.println("Ditemukan 1 baris 0 semua,(Solusi Banyak)");
            }
        }
        else
        {

            Float[] ansTab =  RegresiLinierBerganda.tulisSolusiRegresi(SPL.solutionGaussJordan(eEqualReg), eEqualReg);
            System.out.println("Persamaan nya adalah : ");
            System.out.print("y = " + ansTab[0]);
            for (int i = 1; i < ansTab.length; i++) {
                if (ansTab[i] > 0)
                {
                    System.out.print(" + " );
                } 
                System.out.print(ansTab[i] + " x" + i + " ");
                
            }
            
            float hampy = 0;
            hampy += ansTab[0];
            System.out.println();
            for (int i = 0; i < matrix.getColEff() - 1; i++) {
                hampy += (matrix.getElmt(matrix.getRowEff() - 1,i) * ansTab[i + 1]);
                System.out.println("X" + (i+1) + " = " + matrix.getElmt(matrix.getRowEff() - 1,i));
            }
            System.out.println("Dan Hampirannya adalah y =  " + hampy);
        }
    




    }

        



    
   
    //tes
    public static Matrix inputMatrixKeyboard(Scanner scanner) {
        int row,col;
        row = 0;
        col = 0;
        
        // Input Jumlah Kolom dan baris
        System.out.println("Masukkan jumlah baris: ");
        row = scanner.nextInt();

        // Pastikan jumlah baris > 0
        while (row < 0) {
            System.out.println("Jumlah baris harus lebih besar dari 0. Masukkan jumlah baris yang valid: ");
            row = scanner.nextInt();
        }

        System.out.println("Masukkan jumlah kolom: ");
        col = scanner.nextInt();

        // Pastikan jumlah kolom > 0
        while (col < 0) {
            System.out.println("Jumlah kolom harus lebih besar dari 0. Masukkan jumlah kolom yang valid: ");
            col = scanner.nextInt();
        }

        Matrix matrix = new Matrix(row, col);

        // Input elemen pada matrix
        System.out.println("Masukkan elemen pada matriks: ");
        for (int i = 0; i < row; i++) {
            {
                for (int j = 0; j < col; j++) {
                    matrix.Matrix[i][j] = scanner.nextDouble();
                }
            }
        }
        return matrix;
    }

    /*  Revisi2 - Ngefix looping kalau file gk ada, suruh input ulang bukan malah quit program
     * Fungsi yang didelete  - inputNamaFileMatriks ->dipindah ke dalam inputFileMatriks biar lebih efisien
    */
    public static Matrix inputFileMatrix( Scanner scanner) {
        String filePath;
        Matrix matrix = new Matrix(0,0);
        do
        {
            try 
            {
                //Input nama file txt
                System.out.print("masukkan nama file txt:  ");
                String filename = scanner.nextLine();
                filePath = "../test/" + filename + ".txt";
                BufferedReader reader = new BufferedReader(new FileReader(filePath));

                String line;
                int RowEff = 0;
                int ColEff = 0;
                int tempColEff = 0;
                // Dapetin jumlah RowEff dan ColEff dari file txt
                while ((line = reader.readLine()) != null) {
                    // RowEff + 1 tiap dibaca line baru
                    RowEff++;

                    String[] elements = line.split(" ");
                    // Panjang array elements menunjukkan banyaknya column
                    tempColEff = elements.length;

                    //Handler bila input ada hampiran lain di baris paling bawah, misal regresi linear ganda dan bicubic dan interpolasi
                    if(tempColEff > ColEff)
                    {
                        ColEff = tempColEff;
                    }

                }
                
                matrix = new Matrix(RowEff, ColEff);
                reader.close();
                // isi ulang
                int i = 0;
                reader = new BufferedReader(new FileReader(filePath));
                while ((line = reader.readLine()) != null) {
                    String[] elements = line.split(" ");
                    for (int j = 0; j < elements.length; j++) {
                        
                        matrix.setElmt(i, j, Double.parseDouble(elements[j]));//Konversi dari elemen string menjadi double
                        
                    }
                    i++;
                }

                reader.close();

            } catch (IOException e) {
                
                System.out.println("\n========================================================");
                System.out.println(" silahkan input nama file txt, ex: tes1 dari tes1.txt");
                System.out.println("========================================================");
                filePath = null;

            }
        }while(filePath == null);

        return matrix;

    }

    

    

}
