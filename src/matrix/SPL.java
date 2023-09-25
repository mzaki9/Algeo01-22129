package matrix;

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
                double increment = m.Matrix[row][i] / cons;
                m.Matrix[row][i] = increment ;
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
    public static void OBEBarisPlusMinusFaseMaju(Matrix m,int i1,int j1,int i2)
    {
        //kurangi seluruh baris i1 dengan i2, dengan konstanta key1/key2 dengan key dari i1 dan j1
        //boolean arah, bila false maka kurangi untuk eliminasi gauss, bila true maka untuk gaussjordan
        //prekondisi : apabila ingin gaussjordan, harus di gauss dulu
        double key1 = m.getElmt(i1, j1);
        
        while(m.getElmt(i2, j1) == 0 && i2 > 0)
        {
            i2 --;
        }

        //sekarang i2 pasti dapat sebagai index yang memiliki elemen bukan 0 ATAU i2 = 0, karena i2 tidak mungkin -1
        double key2 = m.getElmt(i2, j1);
        if (key2 == 0)
        {
            //handler error
            key2 = 1;
        }
      
        double cons = Math.abs((key1/key2));
        
        for (int k = j1; k < m.getColEff(); k++) 
            {
                if((key1 > 0 && key2 < 0) || (key1 < 0 && key2 > 0))
                {

                    double increment =(m.getElmt(i1, k) + (cons * m.getElmt(i2, k)));
                    // System.out.println(m.getElmt(i1, k) + " + (" + cons + "*" + m.getElmt(i2, k)+")");
                    
                    m.setElmt(i1, k, increment);
                }
                else
                {
                    //NANTI UNTUK KONVERSI INI AKAN DIBUAT FUNGSI PEMBANTU MISALNYA : doubleToString, stringToDouble, untuk sekarang seperti ini dulu
                    double increment = (m.getElmt(i1, k) - (cons * m.getElmt(i2, k)));
                    //  System.out.println(m.getElmt(i1, k) + " - (" + cons + "*" + m.getElmt(i2, k)+")");
                    m.setElmt(i1, k, increment);
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
        int j = m.getColEff() - 2;
        for (int i = 0; i < m.getRowEff(); i++) 
        {
            //mulai dari kolom bukan "b" dari kanan
            while (j > 0 && m.getElmt(i, j) == 0) 
            {
                j--;
            }
           
        }
        return (j == 0);
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
    public static boolean cekBarisUnik(Matrix m, int row)
    //mengembalikan nilai true apabila baris itu hasil unik / koefisien 1
    {
        int count = 0;
        for (int j = 0; j < m.getColEff() - 1; j++) {
            if(m.getElmt(row, j) == 0)
            {
                count ++; 
            }
        }
        return (count == m.getColEff() - 2);
    }

    public static Matrix createMatriksEselon( Matrix m)
    {
        //Prekondisi: tidak ada 1 kolom yang 0 semua / koefisien trash
        // Pengecekan apabila baris ke-1 0 atau 1 bukan
        int i = 0;
        int i1 = 0;
        while (i1 < m.getRowEff() && m.getElmt(i1, 0) != 1) {
            i1++;
        }
        while (i < m.getRowEff() && m.getElmt(i, 0) == 0 )
        {
            i++;
        }
        if(i != m.getRowEff())
        {
            swapBaris(m, 0, i);
        }
       
        if (i1 != m.getRowEff() && m.getElmt(0, 0) != 1)
        {
            swapBaris(m, 0, i1);
        }
       
       
        
        buat1Utama(m, 0);
    
        int batasAugmented = m.getColEff() - 1;
        int k = 1;
        //Mulai algoritma Gauss
        for (int j = 0; j < batasAugmented ; j++) 
        {
            for (i = 1 + j  ;i < m.getRowEff(); i++) 
            { 
                if(cekBarisUnik(m,i) == false)
                {
                    OBEBarisPlusMinusFaseMaju(m, i, j,j);
                }
            }
            if(k < m.getRowEff() )
            {
                buat1Utama(m, k);
            }
            k++;
        }
        //Kalau ada yang sama barisnya, dibuat 0 slaah satu, untuk mempermudah perhitungan nantinya
        delBarisSama(m);
        return m;
        
    }
    public static boolean cekKolom0(Matrix m,int col)
    {
        int flag = 0;
        for (int i = 0; i < m.getRowEff(); i++) {
            if(m.getElmt(i, col) == 0)
            {
                flag++;
            }
            
        }
        return(flag == m.getRowEff()- 1);
    }
    public static void eliminasiGaussJordan(Matrix m)
    {
        //Prekondisi : Harus di eselon baris dulu matrkisnya
        int k;
        int j1utama = 0;
        int batasAugmented = m.getColEff() - 1;
        for (int i = 1; i < m.getRowEff() ; i++) 
        {
            j1utama = 0;
            while (m.getElmt(i, j1utama)!= 1 && j1utama < batasAugmented) 
            {
                j1utama++;
            }
            if(j1utama == batasAugmented)
            {
                continue;
            }
            
            for (int i1utama = 0; i1utama < j1utama; i1utama++) {
                if(i1utama == m.getRowEff() - 1)
                {
                    break;
                }
                double cons =Math.abs(m.getElmt(i1utama, j1utama));
                double key = m.getElmt(i1utama, j1utama);
               
                for (k = 0; k < m.getColEff(); k++) 
                {
                    
                    if (key > 0)
                    {
                        double hasil = m.getElmt(i1utama, k) - (cons * m.getElmt(i, k));
                        m.setElmt(i1utama, k, hasil);
                    }
                    else//key negatif
                    {
                        double hasil = m.getElmt(i1utama, k) + (cons * m.getElmt(i, k));
                        m.setElmt(i1utama, k, hasil);
                    }
                   
                }
                
              
                
                
                


                
            }
            //udah nemu 1 utama
            
            
            
            
        }
        
            
        
        
    }

    public static Matrix inverseMatrix(Matrix m) {
        int n = m.getRowEff();


        //TO-DO add pengecekan apakah matrix solveable

        Matrix matrixTanpaB = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixTanpaB.setElmt(i, j, m.getElmt(i, j));
            }
        }

        Matrix hasil  = new Matrix(m.getRowEff(), m.getRowEff());
        hasil = MatrixBalikan.GaussJordan(matrixTanpaB);

        return hasil;
    }

    public static Matrix solveX(Matrix m) {

        // Deklarasi
        Matrix hasil = new Matrix(m.getRowEff(), m.getRowEff());
        Matrix b = new Matrix(m.getRowEff(), 1);
        hasil = inverseMatrix(m);

        // Ambil "b" dari matrix original
        for (int i = 0; i < m.getRowEff(); i++) {
            double bValue = m.getElmt(i, m.getColEff() - 1); 
            b.setElmt(i, 0, bValue); 
        }

        Matrix x = new Matrix(hasil.getRowEff(), 1);


        //X = hasil^-1 * b
        for (int i = 0; i < hasil.getRowEff(); i++) {
            double sum = 0.0;
            for (int j = 0; j < hasil.getColEff(); j++) {
                sum += hasil.getElmt(i, j) * b.getElmt(j, 0);
            }
            x.setElmt(i, 0, sum);
        }

        return x;
    }

        
    

   

        
    
}
