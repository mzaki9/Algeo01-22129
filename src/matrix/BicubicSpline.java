package matrix;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import iomatrix.OutputMatrix;

import java.awt.image.BufferedImage;


//TES
public class BicubicSpline {

    public static void fungsif(int bariskoef, Matrix koef) {
        int x = 0, y = 0;
        if (bariskoef % 4 == 0) {
            x = 0;
            y = 0;
        } else if (bariskoef % 4 == 1) {
            x = 0;
            y = 1;
        } else if (bariskoef % 4 == 2) {
            x = 1;
            y = 0;
        } else if (bariskoef % 4 == 3) {
            x = 1;
            y = 1;
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                int colCoef = 4 * (i) + j + 1 - 1;
                koef.setElmt(bariskoef, colCoef, (Math.pow(x, i) * Math.pow(y, j)));
            }
        }

    }

    public static void fungsifx(int bariskoef, Matrix koef) {
        int x = 0, y = 0;
        if (bariskoef % 4 == 0) {
            x = 0;
            y = 0;
        } else if (bariskoef % 4 == 1) {
            x = 1;
            y = 0;
        } else if (bariskoef % 4 == 2) {
            x = 0;
            y = 1;
        } else if (bariskoef % 4 == 3) {
            x = 1;
            y = 1;
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    continue;
                }
                int colCoef = 4 * (j) + i + 1 - 1;
                koef.setElmt(bariskoef, colCoef, i * (Math.pow(x, i - 1) * Math.pow(y, j)));
            }
        }

    }

    public static void fungsify(int bariskoef, Matrix koef) {
        int x = 0, y = 0;
        if (bariskoef % 4 == 0) {
            x = 0;
            y = 0;
        } else if (bariskoef % 4 == 1) {
            x = 1;
            y = 0;
        } else if (bariskoef % 4 == 2) {
            x = 0;
            y = 1;
        } else if (bariskoef % 4 == 3) {
            x = 1;
            y = 1;
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (j == 0) {
                    continue;
                }
                int colCoef = 4 * (j) + i + 1 - 1;
                koef.setElmt(bariskoef, colCoef, j * (Math.pow(x, i) * Math.pow(y, j - 1)));
            }
        }

    }

    public static void fungsifxy(int bariskoef, Matrix koef) {
        int x = 0, y = 0;
        if (bariskoef % 4 == 0) {
            x = 0;
            y = 0;
        } else if (bariskoef % 4 == 1) {
            x = 1;
            y = 0;
        } else if (bariskoef % 4 == 2) {
            x = 0;
            y = 1;
        } else if (bariskoef % 4 == 3) {
            x = 1;
            y = 1;
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (j == 0 || i == 0) {
                    continue;
                }
                int colCoef = 4 * (j) + i + 1 - 1;
                koef.setElmt(bariskoef, colCoef, i * j * (Math.pow(x, i - 1) * Math.pow(y, j - 1)));
            }
        }

    }

    public static Matrix bikinKoef(Matrix koef) {
        for (int i = 0; i < 16; i++) {
            if (i < 4) {
                fungsif(i, koef);
            } else if (i < 8) {
                fungsifx(i, koef);
            } else if (i < 12) {
                fungsify(i, koef);
            } else if (i < 16) {
                fungsifxy(i, koef);
            }
        }
        return koef;
    }

    public static double fspline(double x, double y, Matrix aij) {
        double absx = Math.abs(x);
        double absy = Math.abs(y);
        double value = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                value += aij.getElmt(i, j) * (Math.pow(absx, i) * Math.pow(absy, j));
            }
        }

        return value;
    }

    public static void koeff(Matrix mat,double x,double y) {
        
        Matrix koef = new Matrix(16, 16), temp = new Matrix(16, 16);
        Tools.copyMatrix(MatrixBalikan.GaussJordan(bikinKoef(temp)), koef);
        Matrix input = new Matrix(16, 1);
        Matrix hasil = new Matrix(16, 1);
        Matrix akhir = new Matrix(4, 4);

        // Ubah matrix input ke 16x1
        for (int i = 0; i < mat.getRowEff(); i++) {
            for (int j = 0; j < mat.getColEff(); j++) {
                input.setElmt(4 * i + j, 0, mat.getElmt(i, j));
            }
        }

        // Kali matrix input dengan koef
        Tools.copyMatrix(Tools.multiplyMatrix(koef, input), hasil);

        // Ubah Ke hasil ke matrix 4x4
        for (int i = 0; i < hasil.getRowEff(); i++) {
            akhir.setElmt(i / 4, i % 4, hasil.getElmt(i, 0));
        }

        // OutputMatrix.tulisMatrix(akhir);
        System.out.println("HASIL : " + fspline(x, y, akhir));
    }

    public static void fungsid(int bariskoef, Matrix D) {
        int x = 0, y = 0;
        if (bariskoef % 4 == 0) {
            x = 0;
            y = 0;
        } else if (bariskoef % 4 == 1) {
            x = 0;
            y = 1;
        } else if (bariskoef % 4 == 2) {
            x = 1;
            y = 0;
        } else if (bariskoef % 4 == 3) {
            x = 1;
            y = 1;
        }

        for (int j = -1; j < 3; j++) {
            for (int i = -1; i < 3; i++) {
                if (i != x || j != y) {
                    continue;
                }
                int colCoef = 4 * (i + 1) + j + 2 - 1;
                D.setElmt(bariskoef, colCoef, 4);
            }
        }
    }

    public static void fungsidx(int bariskoef, Matrix D) {
        int x = 0, y = 0;
        if (bariskoef % 4 == 0) {
            x = 0;
            y = 0;
        } else if (bariskoef % 4 == 1) {
            x = 1;
            y = 0;
        } else if (bariskoef % 4 == 2) {
            x = 0;
            y = 1;
        } else if (bariskoef % 4 == 3) {
            x = 1;
            y = 1;
        }

        for (int j = -1; j < 3; j++) {
            for (int i = -1; i < 3; i++) {
                double a1 = 0, a2 = 0;
                
                if (j == x + 1 && i == y) {
                    a1 = 1;
                }
                if (j == x - 1 && i == y) {
                    a2 = -1;
                }

                int colCoef = 4 * (i + 1) + j + 2 - 1;
                D.setElmt(bariskoef, colCoef, 4 * (a1 + a2) / 2);
            }
        }
    }

    public static void fungsidy(int bariskoef, Matrix D) {
        int x = 0, y = 0;
        if (bariskoef % 4 == 0) {
            x = 0;
            y = 0;
        } else if (bariskoef % 4 == 1) {
            x = 1;
            y = 0;
        } else if (bariskoef % 4 == 2) {
            x = 0;
            y = 1;
        } else if (bariskoef % 4 == 3) {
            x = 1;
            y = 1;
        }

        for (int j = -1; j < 3; j++) {
            for (int i = -1; i < 3; i++) {
                double a1 = 0, a2 = 0;
                
                if (j == x && i == y + 1) {
                    a1 = 1;
                }
                if (j == x && i == y - 1) {
                    a2 = -1;
                }

                int colCoef = 4 * (i + 1) + j + 2 - 1;
                D.setElmt(bariskoef, colCoef, 4 * (a1 + a2) / 2);
            }
        }
    }

    public static void fungsidxy(int bariskoef, Matrix D) {
        int x = 0, y = 0;
        if (bariskoef % 4 == 0) {
            x = 0;
            y = 0;
        } else if (bariskoef % 4 == 1) {
            x = 1;
            y = 0;
        } else if (bariskoef % 4 == 2) {
            x = 0;
            y = 1;
        } else if (bariskoef % 4 == 3) {
            x = 1;
            y = 1;
        }
        for (int j = -1; j < 3; j++) {
            for (int i = -1; i < 3; i++) {
                double a1 = 0, a2 = 0, a3 = 0, a4 = 0;
                
                if (j == x + 1 && i == y + 1) {
                    a1 = 1;
                }
                if (j == x - 1 && i == y) {
                    a2 = -1;
                }
                if (j == x && i == y - 1) {
                    a3 = -1;
                }
                if (j == x && i == y) {
                    a4 = -1;
                }

                int colCoef = 4 * (i + 1) + j + 2 - 1;
                D.setElmt(bariskoef, colCoef, a1 + a2 + a3 + a4);
            }
        }
    }

    public static Matrix bikinKoefD(Matrix koefD) {
        for (int i = 0; i < 16; i++) {
            if (i < 4) {
                fungsid(i, koefD);
            } else if (i < 8) {
                fungsidx(i, koefD);
            } else if (i < 12) {
                fungsidy(i, koefD);
            } else if (i < 16) {
                fungsidxy(i, koefD);
            }
        }
        return koefD;
    }

    public static double spline(Matrix matrix, double x, double y) {
        Matrix koefD = new Matrix(16, 16), tempD = new Matrix(16, 16);
        Tools.copyMatrix(bikinKoefD(tempD), koefD);
        Matrix koefX = new Matrix(16, 16), tempX = new Matrix(16, 16);
        Tools.copyMatrix(MatrixBalikan.GaussJordan(bikinKoef(tempX)), koefX);
        Matrix XD = new Matrix(16, 16);
        Tools.copyMatrix(Kofaktor.DividebyCons(Tools.multiplyMatrix(koefX,koefD),4),XD);
        Matrix input = new Matrix(16,1), hasil = new Matrix(16,1), akhir = new Matrix(4,4);
        for (int i = 0; i < matrix.getRowEff(); i++) {
            for (int j = 0; j < matrix.getColEff(); j++) {
                input.setElmt(4 * i + j, 0, matrix.getElmt(i, j));
            }
        }
        Tools.copyMatrix(Tools.multiplyMatrix(XD,input),hasil);
          for (int i = 0; i < hasil.getRowEff(); i++) {
            akhir.setElmt(i / 4, i % 4, hasil.getElmt(i, 0));
        }
        return fspline(x, y, akhir);
    }
    // public static void main(String[] args){
    //     OutputMatrix.tulisMatrix(splineId());
    // }
    
}
