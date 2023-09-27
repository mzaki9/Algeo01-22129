
import java.util.Scanner;

import iomatrix.*;
import matrix.*;

//tes
public class mainprogram {
    public static void main(String[] args)
    {
        
        //Scanner utama buat main
        Scanner scanner = new Scanner(System.in);
        //Matrix matrix = InputMatrix.inputFileMatrix(scanner);
        //Matrix matrix = InputMatrix.inputMatrixKeyboard(scanner);

        /*Input untuk interpolasi */
        Matrix matrix = InputMatrix.inputInterpolasi(scanner);
        InterpolasiPolinomial.Interpolasi(matrix);
        
        // SPL.Cramer(matrix);
        //SPL.inverseMatrix(matrix);

        //TES GAUSSJORDAN
        //SPL.createMatriksEselon(matrix);
        //SPL.eliminasiGaussJordan(matrix);
        
        //OutputMatrix.tulisSolusiGaussJordan(SPL.solutionGaussJordan(matrix), matrix);
        //OutputMatrix.tulisMatrix(Tools.konversiFloattoDouble(matrix));
        
       

    }
    
}
