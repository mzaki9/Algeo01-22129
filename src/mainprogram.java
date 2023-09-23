
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
        OutputMatrix.tulisMatrix(matrix);
        SPL.createMatriksEselon(matrix);
        System.out.println("===============AKHIR===============");
        OutputMatrix.tulisMatrix(Tools.konversiFloattoDouble(matrix));

        //OutputMatrix.MatriksKeTXT(matrix);

    }
    
}
