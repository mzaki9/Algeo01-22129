package matrix;

public class DeterminanOBE {

    public static boolean isMatrixSquare(Matrix m)
    {
        return (m.getColEff() == m.getRowEff());
    }

    public static double getElmtDiagonal(Matrix m , int i)
    {
        return m.getElmt(i,i);
    }

    public static double determinanOBE(Matrix m)
    {
        double det = 1;
        if(!(isMatrixSquare(m)))
        {
            return 0;
        }
        else
        {
            int i,i2,j,k;
            double cons,key1,key2;
            i2 = 0;
            cons = 1;
            i = 0;
            


            for (i = 0; i < m.getRowEff(); i++) {
                i2 = i;
                while(getElmtDiagonal(m, i2) == 0&& i2 < m.getRowEff())
                {
                    
                    i2 ++;
                }
                if(i2 == m.getRowEff())
                {
                    return 0;
                }
                if(i != i2)
                {
                    det *= -1;

                    for (j = 0; j < m.getColEff(); j++) {
                        SPL.swapBaris(m, i, i2);
                    }
                }
            }

            for (i = 1; i < m.getRowEff(); i++) {
                for (j= 0; j < i; j++) {
                    if (m.getElmt(i, j) != 0)
                    {
                        key1 = m.getElmt(i, j);
                        i2 = i -1;
                        while(Math.abs(m.getElmt(i2, j)) < 0.00001)
                        {
                            i2 --;
                        }
                        key2 = m.getElmt(i2, j);
                        cons = Math.abs(key1/key2);

                        for (k = 0; k< m.getColEff(); k++) {
                            if((key1 > 0 && key2 < 0) || (key1 < 0 && key2 > 0))
                            {
                                m.setElmt(i, k, m.getElmt(i, k) + (cons * (m.getElmt(i2, k))));
                            }
                            else if((key1 > 0 && key2 > 0) || (key1 < 0 && key2 < 0))
                            {
                                m.setElmt(i, k, m.getElmt(i, k) - (cons * (m.getElmt(i2, k))));
                            }
                        }
                    }
                    
                }
            }
            for (i = 0; i< m.getRowEff(); i++) {
                det *= m.getElmt(i, i);
            }
        }

        return(det);
        

    }
}
