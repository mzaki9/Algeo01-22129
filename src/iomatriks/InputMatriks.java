package iomatriks;

import java.io.*;
import java.util.Scanner;


public class InputMatriks {
    public static double[][] inputFileMatriks(String filename , Scanner scanner)
    {
        double[][] matrix = null;
        String filePath = "../test/"+ filename + ".txt";
        
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int RowEff = 0;
            int ColEff = 0;
            //Dapetin jumlah RowEff dan ColEff dari file txt
            while((line = reader.readLine()) != null)
            {
                //RowEff + 1 tiap dibaca line baru
                RowEff ++;
                
                String[] elements = line.split(" ");
                //Panjang array elements menunjukkan banyaknya column
                ColEff =  elements.length;
            
            }
            
            matrix = new double[RowEff][ColEff];
            reader.close();
            //isi ulang
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
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("========================================================") ;
            System.out.println("ERROR! File tidak ditemukan, keluar program! (for now)") ;
            System.out.println("========================================================") ;
            
        }
    

        return matrix;

    }
    public static void tulisMatriks(double[][] M)
    {
        for (int i = 0; i < M.length; i++)
        {
            for (int j = 0; j< M[i].length;j++)
            {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] inputNamaFileMatriks(Scanner scanner)
    {
        
        System.out.print("masukkan nama file txt:  ");
        String namafile = scanner.nextLine();

        return inputFileMatriks(namafile, scanner);
    }

    

    

    
}
