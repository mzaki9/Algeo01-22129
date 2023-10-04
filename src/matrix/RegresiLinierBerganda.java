package matrix;

import iomatrix.OutputMatrix;

public class RegresiLinierBerganda {
    
    public static Matrix regresiGanda(Matrix m)
    //Prekondisi : Menerima matriks yang sudah berbentuk data regresi linier
    //Mengembalikan Matrix eEquation(matriks yang sudah diolah dengan Rumus Normal Equation)
    {
        Matrix eEquation = new Matrix(m.getColEff(),m.getColEff() + 1);
        for (int k= 0; k < eEquation.getRowEff(); k++) {
            for (int colE = 0; colE < eEquation.getColEff() - 1; colE++) {
                double sum = 0;
                if(k == 0 && colE == 0)
                {
                    eEquation.setElmt(k, colE, m.getElmt(colE, k) + m.getRowEff());
                }
                else
                {
                    for (int i = 0; i < m.getRowEff(); i++) {
                        if(k == 0 )
                        {
                            sum += (m.getElmt(i, colE-1));
                        }
                        else if(colE == 0)
                        {
                            sum += (m.getElmt(i, k-1));
                        }
                       
                        else
                        {
                            sum += (m.getElmt(i, k-1) * (m.getElmt(i, colE-1)));
                        }
                        
                        
                    }
                    
                }
                
                eEquation.setElmt(k, colE, sum);
 
            }
            double sum = 0;
            for (int i = 0; i < m.getRowEff(); i++) {
                if (k == 0)
                {
                    sum += m.getElmt(i, m.getColEff() - 1);
                }
                else
                {
                    sum += (m.getElmt(i, m.getColEff() - 1) * m.getElmt(i, k-1));
                }
                
            }
            eEquation.setElmt(k, eEquation.getColEff()-1, sum);

        }
        
            
        
        return eEquation;

    }
    public static double sumKolom(Matrix m,int col)
    //Sigma dalam rumus Normal Equation, menjumlahkan seluruh baris dalam col tersebut
    {
        double sum = 0;
        for (int i= 0; i < m.getRowEff(); i++) {
            sum += m.getElmt(i, col);
        }
        return sum;
    }
    public static Float[] tulisSolusiRegresi(String[] ans, Matrix m) {
            System.out.println("=============SOLUSI===============");
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] != "") {
                    System.out.println("X" + (i + 1) + " =" + " " + ans[i]);
                } else {
                    System.out.println("X" + (i + 1) + " = " + "R" + (i + 1));
                }
            }
            System.out.println("===================================");
            //Konversi dari jawaban string ke float
            Float[] floatAns = new Float[ans.length];
            for (int i= 0; i < ans.length; i++) {
                floatAns[i] = Float.parseFloat(ans[i]);
                // System.out.println(floatAns[i]);
            }
        return floatAns;
    }

   
}
