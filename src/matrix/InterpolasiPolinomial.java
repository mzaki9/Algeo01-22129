package matrix;

import iomatrix.OutputMatrix;

import java.lang.Math;
import java.util.Scanner;

public class InterpolasiPolinomial {

    public static Matrix Interpolasi(Matrix m, boolean isFile) {
        double x = 0;
        Matrix result = new Matrix(1, 1);
        Matrix augMatrix = null;

        if(isFile){
            Matrix temp = new Matrix(m.getRowEff()-1,m.getColEff());
            //Isi Matrix noX
            for(int i = 0; i < temp.getRowEff();i++){
                for(int j =0; j< temp.getColEff();j++){
                    temp.setElmt(i, j, m.getElmt(i, j));
                }
            }
            augMatrix = createAugmentedMatrix(temp);

            //Isi nilai x yang nanti akan dicoba
            x = m.getElmt(m.getRowEff()-1, 0);
        }else{
            augMatrix = createAugmentedMatrix(m);
            System.out.println("Masukkan Nilai X untuk Diuji :");
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextDouble();
        }

        
        Matrix hasil = null;
        hasil = SPL.Cramer(augMatrix);
        if (hasil == null){
            return null;
        }
        //Tools.copyMatrix(SPL.Cramer(augMatrix), hasil);
        OutputMatrix.tulisSolusiInterpolasiP(hasil);

        double temp = 0;
        for (int i = 0; i < hasil.getRowEff(); i++) {
                temp += hasil.getElmt(i, 0) * Math.pow(x, i);
            }
        System.out.println("Hasilnya adalah: " + temp);
        result.setElmt(0, 0, temp);
        return result;

    }

    public static Matrix createAugmentedMatrix(Matrix dataXY) {
        int derajat = dataXY.getRowEff();
        Matrix augmentedMatrix = new Matrix(derajat, derajat + 1);

        for (int i = 0; i < augmentedMatrix.getRowEff(); i++) {
            for (int j = 0; j < augmentedMatrix.getColEff(); j++) {
                if (j == augmentedMatrix.getColEff() - 1) {
                    augmentedMatrix.setElmt(i, j, dataXY.getElmt(i, 1));
                } else {
                    augmentedMatrix.setElmt(i, j, Math.pow(dataXY.getElmt(i, 0), j));
                }
            }
        }

        return augmentedMatrix;
    }
}
