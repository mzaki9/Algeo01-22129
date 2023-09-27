package matrix;

import iomatrix.OutputMatrix;

import java.lang.Math;

public class InterpolasiPolinomial {

    public static void Interpolasi(Matrix m) {
        Matrix augMatrix = createAugmentedMatrix(m);
        //OutputMatrix.tulisMatrix(augMatrix);
        SPL.Cramer(augMatrix);
 
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
