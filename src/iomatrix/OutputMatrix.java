package iomatrix;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import matrix.Matrix;

//tes

public class OutputMatrix {
    public static void tulisMatrix(Matrix M) {
        for (int i = 0; i < M.getRowEff(); i++) {
            for (int j = 0; j < M.getColEff(); j++) {
                System.out.print(M.getElmt(i, j) + " ");
            }
            System.out.println();
        }
    }

        
    public static String dir = "../test";
    public static String path = "";
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
    

    
    public static void createFile(){
        try{
            pathMaker();
            Date date = new Date();
            File file = new File(dir + formatter.format(date) + ".txt");
            if (!file.exists()){
                file.createNewFile();
            }
            path = file.getAbsolutePath();
        }
        catch (IOException e){
            System.out.println("Terjadi error.");
            JOptionPane.showMessageDialog(null,"Terjadi error. " ,"Error!", JOptionPane.ERROR_MESSAGE); 
        }
    }
        
    public static String matrixToString(Matrix M){
        String s = "";
        for (int i = 0; i < M.getRowEff(); i++) {
            for (int j = 0; j < M.getColEff(); j++){
                if(j == M.getColEff()){
                    s += M.getElmt(i, j);
                }
                else{
                    s += M.getElmt(i, j) + " ";
                }
            }
            s += "\n";
        }
        return s;
    }


    public static void pathMaker(){
        String directory = System.getProperty("user.dir");
        directory = directory.substring(directory.lastIndexOf("\\")+1);
        if(directory.equals("bin")){
            dir = "..\\test\\result\\";
        }
        else{
            dir = "test\\result\\";
        }
    }  

    public static void MatriksKeTXT(Matrix M){
        try{
            createFile();
            FileWriter wr = new FileWriter(path);
            String s = matrixToString(M);
            wr.write(s);
            wr.close();
            System.out.println("Sukses menulis file.");
            JOptionPane.showMessageDialog(null,"Sukses menulis file. " ,"SUKSES", JOptionPane.PLAIN_MESSAGE); 
        }
        catch(IOException e){
            System.out.println("Terjadi error.");
            JOptionPane.showMessageDialog(null,"Terjadi error. " ,"Error!", JOptionPane.ERROR_MESSAGE); 
        }
    }
}
    

