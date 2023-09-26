package matrix;
import java.text.DecimalFormat;

public class Tools 
{
    public static Matrix konversiFloattoDouble(Matrix m )
    {
        for (int i = 0; i < m.getRowEff(); i++) {
            for (int j = 0; j < m.getColEff(); j++) {
                    double increment = m.getElmt(i, j);
                    DecimalFormat df = new DecimalFormat("#.##");
                    String hasil = df.format(increment);
                    double nilaiBulat = Double.parseDouble(hasil);
                    m.setElmt(i, j, nilaiBulat);

                
            }
        }
        return m;
    }

    public static void copyMatrix(Matrix ref,Matrix dest){
        //Prekondisi Ukuran matrix sama
        for (int i = 0; i < ref.getRowEff(); i++) {
            for (int j = 0; j < ref.getColEff(); j++) {
                dest.setElmt(i, j, ref.getElmt(i, j));
            }
        }
    }
    
}
