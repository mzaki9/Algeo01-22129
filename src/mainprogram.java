
import java.util.Scanner;

import iomatrix.*;
import matrix.*;

//tes
public class mainprogram {
    public static void main(String[] args)
    {
        
        //Scanner utama buat main
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = InputMatrix.inputMatrixKeyboard(scanner);
        OutputMatrix.tulisMatrix(SPL.findX(matrix));
        

        //OutputMatrix.MatriksKeTXT(matrix);

    }
    
}
