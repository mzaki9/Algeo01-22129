
import java.util.Scanner;
import iomatriks.*;

public class mainprogram {
    public static void main(String[] args)
    {
        
        //Scanner utama buat main
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = InputMatriks.inputMatriksKeyboard(scanner);
        OutputMatriks.tulisMatriks(matrix);
    }
    
}
