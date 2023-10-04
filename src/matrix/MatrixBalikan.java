package matrix;

public class MatrixBalikan {

    public static Matrix GaussJordan(Matrix m) {


        Matrix augmentedMatrix = new Matrix(m.getRowEff(), m.getRowEff() * 2);

        // Buat Matrix dengan [Matrix asal | Matrix Identitas]
        for (int i = 0; i < m.getRowEff(); i++) {
            for (int j = 0; j < m.getRowEff(); j++) {
                augmentedMatrix.setElmt(i, j, m.getElmt(i, j));
                // J+N agar membuat matrix identitas
                // dan N agar membuat matrix identitas di sebelah kanan matrix
                // asal agar tidak bertabarakan
                if (i == j) {
                    augmentedMatrix.setElmt(i, j + m.getRowEff(), 1);
                } else {
                    augmentedMatrix.setElmt(i, j + m.getRowEff(), 0);
                }
            }
        }

        // Start Gauss-Jordan :(
        for (int i = 0; i < m.getRowEff(); i++) {
            if (augmentedMatrix.getElmt(i, i) == 0) {

                int swapRow = -1;
                for (int k = i + 1; k < m.getRowEff(); k++) {
                    if (augmentedMatrix.getElmt(k, i) != 0) {
                        swapRow = k;
                        break;
                    }
                }

                if (swapRow != -1) {
                    Tools.swapBaris(augmentedMatrix, i, swapRow);

                } else {
                    System.out.println("Matrix tidak mempunyai balikan");
                    return null;
                }
            }
            double key = augmentedMatrix.getElmt(i, i);
            for (int j = 0; j < 2 * m.getRowEff(); j++) {

                augmentedMatrix.setElmt(i, j, augmentedMatrix.getElmt(i, j) / key);
            }

            // Membuat 0 elemen yang bukan diagonal
            for (int k = 0; k < m.getRowEff(); k++) {
                //
                if (k != i) {
                    double factor = augmentedMatrix.getElmt(k, i);
                    for (int j = 0; j < 2 * m.getRowEff(); j++) {
                        augmentedMatrix.setElmt(k, j,
                                augmentedMatrix.getElmt(k, j) - factor * augmentedMatrix.getElmt(i, j));
                    }
                }
            }
        }

        Matrix inverseMatrix = new Matrix(m.getRowEff(), m.getRowEff());
        for (int i = 0; i < m.getRowEff(); i++) {
            for (int j = 0; j < m.getRowEff(); j++) {
                inverseMatrix.setElmt(i, j, augmentedMatrix.getElmt(i, j + m.getRowEff()));
            }
        }

        return inverseMatrix;
    }

}
