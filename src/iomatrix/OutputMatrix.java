package iomatrix;

import matrix.*;

public class OutputMatrix {
    public static void tulisMatrix(Matrix M) {
        for (int i = 0; i < M.getRowEff(); i++) {
            for (int j = 0; j < M.getColEff(); j++) {
                System.out.print(M.getElmt(i, j) + " ");
            }
            System.out.println();
        }
    }
}
