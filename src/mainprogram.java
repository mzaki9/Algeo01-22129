
import java.util.Scanner;

import iomatrix.*;
import matrix.*;

public class mainprogram {
    public static void main(String[] args)
    {
        
        //Scanner utama buat main
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = InputMatrix.inputMatrixKeyboard(scanner);
        OutputMatrix.tulisMatrix(matrix);
    }
    
}
