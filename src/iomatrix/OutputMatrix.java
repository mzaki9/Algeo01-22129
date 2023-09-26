package iomatrix;
import java.io.*;
import javax.swing.JOptionPane;
import matrix.Matrix;

public class OutputMatrix {
    public static void tulisMatrix(Matrix M) {
        for (int i = 0; i < M.getRowEff(); i++) {
            for (int j = 0; j < M.getColEff(); j++) {
                System.out.print(M.getElmt(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static void printSolution(Matrix x) {

        System.out.println("Solusi Sistem Persamaan Linear:");
        for (int i = 0; i < x.getRowEff(); i++) {
            System.out.printf("x%d = %f\n", (i + 1), x.getElmt(i, 0));
        }
    }
        
    public static String dir = "../test";
    public static String path = "";

    

    
    public static void createFile(){
        try{
            pathMaker();
            File file = new File(dir + "result.txt");
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
            dir = "..\\test\\";
        }
        else{
            dir = "test\\";
        }
    }  

    public static void TuliskeTxt(String s){
        try{
            createFile();
            FileWriter wr = new FileWriter(path);
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
//test output ke file
    // public static void main(String[] args){
    //     TuliskeTxt("string");
    // }
}
    

