
import java.util.Scanner;

import iomatrix.*;
import matrix.*;

//tes
public class mainprogram {
    public static void main(String[] args)
    {
        
        //Scanner utama buat main
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = InputMatrix.inputFileMatrix(scanner);
        
        // SPL.Cramer(matrix);
        // SPL.inverseMatrix(matrix);

        //TES GAUSSJORDAN
        SPL.createMatriksEselon(matrix);
        SPL.eliminasiGaussJordan(matrix);
        OutputMatrix.tulisMatrix(Tools.konversiFloattoDouble(matrix));
        OutputMatrix.tulisSolusiGaussJordan(SPL.solutionGaussJordan(matrix), matrix);
        
        
       

    }
    
}
