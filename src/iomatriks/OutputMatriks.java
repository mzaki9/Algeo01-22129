package iomatriks;

public class OutputMatriks {
    public static void tulisMatriks(double[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

        
    private String dir = "test\\result\\";
    private String path = "";
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
    

    
    public void createFile(){
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
        
    public String matrixToString(double[][] M){
        String s = "";
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++){
                if(j == M[i].length){
                    s += M[i][j];;
                }
                else{
                    s += M[i][j] + " ";
                }
            }
            s += "\n";
        }
        return s;
    }


    public void pathMaker(){
        String directory = System.getProperty("user.dir");
        directory = directory.substring(directory.lastIndexOf("\\")+1);
        if(directory.equals("bin")){
            dir = "..\\test\\result\\";
        }
        else{
            dir = "test\\result\\";
        }
    }  

    public void MatriksKeTXT(double[][] M){
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
    

