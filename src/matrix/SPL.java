package matrix;
import java.text.DecimalFormat;

import iomatrix.*;
public class SPL {

    public static void buat1Utama(Matrix m, int row)
    //Menerima 1 baris dalam matrix, dan tentukan 1 utama serta dibagi dalam kolom "row tsb.
    //Prekondisi : matrix sudah di cek apabila fungsi noSolution = false
    {
        int k = 0;
        while(m.getElmt(row,k ) == 0 && k < m.getColEff() - 1)
        {
            k ++;
        }
        double cons = m.getElmt(row, k);
        if(m.getElmt(row, k) != 1 && cons != 0)
        {
            for (int i = k; i < m.getColEff(); i++) 
            {
                //NANTI UNTUK KONVERSI INI AKAN DIBUAT FUNGSI PEMBANTU MISALNYA : doubleToString, stringToDouble, untuk sekarang seperti ini dulu
                double increment = m.Matrix[row][i] / cons;
                DecimalFormat df = new DecimalFormat("#.##");
                String hasil = df.format(increment);
                double nilaiBulat = Double.parseDouble(hasil);
                m.Matrix[row][i] = nilaiBulat ;
            }   
        }
        
        //mungkin dikanan nya ada nilai bukan 0

    }
    public static void swapBaris(Matrix m,int i1,int i2)
    //tukar baris, misal baris 1 dengan 2
    {   
        double temp;

        for (int j = 0; j < m.getColEff(); j++) 
        {
            temp = m.getElmt(i1, j);
            m.setElmt(i1, j, (m.getElmt(i2, j)));
            m.setElmt(i2, j, (temp));
        }
    }
    public static void OBEBarisPlusMinus(Matrix m,int i1,int j1,int i2)
    {
        //kurangi seluruh baris i1 dengan i2, dengan konstanta key1/key2 dengan key dari i1 dan j1
        double key1 = m.getElmt(i1, j1);
        
        
        while(m.getElmt(i2, j1) == 0 && i2 >= 0)
        {
            i2 --;
        }
        //sekarang i2 pasti dapat sebagai index yang memiliki elemen bukan 0 ATAU i2 = 0, karena i2 tidak mungkin -1
        double key2 = m.getElmt(i2, j1);
        double cons = Math.abs((key1/key2));
        
        for (int k = j1; k < m.getColEff(); k++) 
            {
                if((key1 > 0 && key2 < 0) || (key1 < 0 && key2 > 0))
                {

                    //NANTI UNTUK KONVERSI INI AKAN DIBUAT FUNGSI PEMBANTU MISALNYA : doubleToString, stringToDouble, untuk sekarang seperti ini dulu
                    double increment =(m.getElmt(i1, k) + (cons * m.getElmt(i2, k)));
                    DecimalFormat df = new DecimalFormat("#.##");
                    String hasil = df.format(increment);
                    double nilaiBulat = Double.parseDouble(hasil);
                    m.setElmt(i1, k, nilaiBulat);
                }
                else
                {
                    //NANTI UNTUK KONVERSI INI AKAN DIBUAT FUNGSI PEMBANTU MISALNYA : doubleToString, stringToDouble, untuk sekarang seperti ini dulu
                    double increment = (m.getElmt(i1, k) - (cons * m.getElmt(i2, k)));
                    DecimalFormat df = new DecimalFormat("#.##");
                    String hasil = df.format(increment);
                    double nilaiBulat = Double.parseDouble(hasil);
                    m.setElmt(i1, k, nilaiBulat);
                }
                
            }

    
    }
    public static boolean cekNoSolution(Matrix m)
    //Cek apabila ditemukan pola tak ada solusi (di baris i semua 0 kecuali di kolomn akhir)
    /*
     * contoh 1 2 2 3
     *        0 1 5 4
     *        0 0 0 1
     */
    {
        int flag;
        for (int i = 0; i < m.getRowEff(); i++) 
        {
            flag = 0;
            for (int j = 0; j < m.getColEff(); j++) 
            {
                if(m.getElmt(i, j) == 0)
                {
                    flag++;
                }
                
            }
            if(flag == m.getColEff() - 1)
                {
                    return true;
                }
        }
        return false;
    }
    public static boolean cekSolusiBanyak(Matrix m)
    //Return true apabila ditemukan 1 baris berisi 0 semua
    {
        int count;
        for (int i = 0; i < m.getRowEff(); i++) 
        {
            count = 0;
            for (int j = 0; j < m.getColEff(); j++) 
            {
                if (m.getElmt(i, j) == 0)
                {
                    count ++;
                }
            }
            if(count == m.getColEff())
            {
                return true;
            }
        }
        return false;
    
    }
    public static int getBarisSama(Matrix m,int row)
    //Mengembalikan baris ke berapa yang isi elemen sama persis dengan baris "row"
    //Bila tidak ditemukan, return baris yang sama dengan row
    {
        int count;
        for (int i = 0; i < m.getRowEff(); i++) 
        {
            count = 0;
            for (int j = 0; j < m.getColEff(); j++)
            {
                if (m.getElmt(i, j) == m.getElmt(row, j) && row != i)
                {
                    count ++;
                }
            }
            if (count == m.getColEff())
            {
                return i;
            }
        }
        return row;
    }
    public static void delBarisSama(Matrix m)
    // baris yang diketahui sama, salah satu nya dibuat jadi 0
    {
        for(int i = 0; i < m.getRowEff() ; i ++)
        {
            if (getBarisSama(m, i) != i)
            {   
                for (int j = 0; j < m.getColEff(); j++) 
                {
                    
                    m.setElmt(i, j, 0);
                    
                }
            }
        }
    }

    public static Matrix createMatriksEselon( Matrix m)
    {
        // Pengecekan apabila baris ke-1 0 atau bukan
        int i = 0;
        while (i < m.getRowEff() && m.getElmt(i, 0) == 0)
        {
            i++;
        }
        swapBaris(m, 0, i);
        buat1Utama(m, 0);
        int batasAugmented = m.getColEff() - 1;
        int k = 1;
        
        //Mulai algoritma Gauss
        for (int j = 0; j < batasAugmented ; j++) 
        {

            for (i = 1 + j; i < m.getRowEff(); i++) 
            { 
                OBEBarisPlusMinus(m, i, j,j);
            }
         
            if(cekNoSolution(m))
            {
                System.out.println("no solution");
                delBarisSama(m);
                return m;
            }
            if(k < m.getRowEff())
            {
                buat1Utama(m, k);
            }
            k++;
        }
        //Kalau ada yang sama barisnya, dibuat 0 slaah satu, untuk mempermudah perhitungan nantinya
        delBarisSama(m);
        return m;
        
    }

        
    

   

        
    
}
