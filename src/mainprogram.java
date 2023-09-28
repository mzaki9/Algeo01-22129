
import java.util.Scanner;

import iomatrix.*;
import matrix.*;

//tes
public class mainprogram {
    public static void main(String[] args)
    {
        
        //Scanner utama buat main
        // Scanner scanner = new Scanner(System.in);
        //Matrix matrix = InputMatrix.inputFileMatrix(scanner);
        // Matrix matrix = InputMatrix.inputMatrixKeyboard(scanner);

        /*Input untuk interpolasi */

        //Menu Interpolasi
        //matrix = InputMatrix.inputInterpolasi(scanner);
        //InterpolasiPolinomial.Interpolasi(matrix);
        
        //TES REGRESI LINEAR BERGANDA
        // InputMatrix.inputRegresiLinier(scanner);
       
        BicubicSpline.koeff();

        //Menu Cramer
        // OutputMatrix.tulisSolusi(SPL.Cramer(matrix,false));

        //SPL.inverseMatrix(matrix);

        //TES GAUSSJORDAN
        // SPL.createMatriksEselon(matrix);
        // SPL.createEselonTereduksi(matrix);
        
        // OutputMatrix.tulisSolusiGaussJordan(SPL.solutionGaussJordan(matrix), matrix);
        // OutputMatrix.tulisMatrix(matrix);
        
        

    }
    }    

