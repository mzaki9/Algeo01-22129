package matrix;

import iomatrix.OutputMatrix;

public class BicubicSpline {

    public static void fungsif(int bariskoef,Matrix  koef)
    {   int x=0,y=0;
        if (bariskoef%4==0){
            x=0;
            y=0;
    }   else if (bariskoef%4==1) {
            x=0;
            y=1;
     }  else if (bariskoef%4==2) {
            x=1;
            y=0;
     }  else if (bariskoef%4==3) {
            x=1;
            y=1;
     }
       
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                int colCoef = 4*(i) + j+1 -1;
                koef.setElmt(bariskoef, colCoef, (Math.pow(x, i) * Math.pow(y, j)));
            }   
        }
            
        
    }
    public static void fungsifx (int bariskoef,Matrix  koef)
    {   int x=0,y=0;
        if (bariskoef%4==0){
            x=0;
            y=0;
    }   else if (bariskoef%4==1) {
            x=1;
            y=0;
     }  else if (bariskoef%4==2) {
            x=0;
            y=1;
     }  else if (bariskoef%4==3) {
            x=1;
            y=1;
     }
       
        for (int j = 0; j< 4;j++) {
            for (int i = 0; i < 4; i++) {
                if (i==0) {
                    continue;
                }
                int colCoef = 4*(j) + i+1 -1;
                koef.setElmt(bariskoef, colCoef, i*(Math.pow(x, i-1) * Math.pow(y, j)));
            }   
        }
            
        
    }
    public static void fungsify (int bariskoef,Matrix  koef)
    {   int x=0,y=0;
        if (bariskoef%4==0){
            x=0;
            y=0;
    }   else if (bariskoef%4==1) {
            x=1;
            y=0;
     }  else if (bariskoef%4==2) {
            x=0;
            y=1;
     }  else if (bariskoef%4==3) {
            x=1;
            y=1;
     }
       
        for (int j = 0; j< 4;j++) {
            for (int i = 0; i < 4; i++) {
                if (j==0) {
                    continue;
                }
                int colCoef = 4*(j) + i+1 -1;
                koef.setElmt(bariskoef, colCoef, j*(Math.pow(x, i) * Math.pow(y, j-1)));
            }   
        }
            
        
    }
    public static void fungsifxy (int bariskoef,Matrix  koef)
   {   int x=0,y=0;
        if (bariskoef%4==0){
            x=0;
            y=0;
    }   else if (bariskoef%4==1) {
            x=1;
            y=0;
     }  else if (bariskoef%4==2) {
            x=0;
            y=1;
     }  else if (bariskoef%4==3) {
            x=1;
            y=1;
     }
       
        for (int j = 0; j< 4;j++) {
            for (int i = 0; i < 4; i++) {
                if (j==0 || i==0) {
                    continue;
                }
                int colCoef = 4*(j) + i+1 -1;
                koef.setElmt(bariskoef, colCoef, i*j*(Math.pow(x, i-1) * Math.pow(y, j-1)));
            }   
        }
            
        
    }
    public static Matrix bikinKoef(Matrix  koef)
    {
        for (int i = 0; i <16;i++){
            if (i <4){
                fungsif(i,koef);
            } else if (i <8){
                fungsifx(i,koef);
            } else if (i <12){
                fungsify(i,koef);
            } else if (i <16){
                fungsifxy(i,koef);
            }
        }
        return koef;
    }

    public static void koeff (){
        Matrix koef=new Matrix(16,16), temp=new Matrix(16,16);
        Tools.copyMatrix(MatrixBalikan.GaussJordan(bikinKoef(temp)),koef);

       OutputMatrix.tulisMatrix(koef);
    
    }


    // public static void fungsid(int bariskoef,Matrix  D,Matrix input)
    // {   int x=0,y=0;
    //     if (bariskoef%4==0){
    //         x=0;
    //         y=0;
    // }   else if (bariskoef%4==1) {
    //         x=0;
    //         y=1;
    //  }  else if (bariskoef%4==2) {
    //         x=1;
    //         y=0;
    //  }  else if (bariskoef%4==3) {
    //         x=1;
    //         y=1;
    //  }
       
    //     for (int j = 0; j < 4; j++) {
    //         for (int i = 0; i < 4; i++) {
    //             int colCoef = 4*(i) + j+1 -1;
    //             D.setElmt(bariskoef, colCoef, 4*input.getElmt(x,y));
    //         }   
    //     }      
    // }

    // public static void fungsidx(int bariskoef,Matrix  D,Matrix input)
    // {   int x=0,y=0;
    //     if (bariskoef%4==0){
    //         x=0;
    //         y=0;
    // }   else if (bariskoef%4==1) {
    //         x=0;
    //         y=1;
    //  }  else if (bariskoef%4==2) {
    //         x=1;
    //         y=0;
    //  }  else if (bariskoef%4==3) {
    //         x=1;
    //         y=1;
    //  }
       
    //     for (int j = 0; j < 4; j++) {
    //         for (int i = 0; i < 4; i++) {
    //             int colCoef = 4*(i) + j+1 -1;
    //             D.setElmt(bariskoef, colCoef, 4*(input.getElmt(x+1,y) - input.getElmt(x-1,y)));
    //         }   
    //     }      
    // }

    // public static void fungsidy(int bariskoef,Matrix  D,Matrix input)
    // {   int x=0,y=0;
    //     if (bariskoef%4==0){
    //         x=0;
    //         y=0;
    // }   else if (bariskoef%4==1) {
    //         x=0;
    //         y=1;
    //  }  else if (bariskoef%4==2) {
    //         x=1;
    //         y=0;
    //  }  else if (bariskoef%4==3) {
    //         x=1;
    //         y=1;
    //  }
       
    //     for (int j = 0; j < 4; j++) {
    //         for (int i = 0; i < 4; i++) {
    //             int colCoef = 4*(i) + j+1 -1;
    //             D.setElmt(bariskoef, colCoef, 4*(input.getElmt(x,y+1) - input.getElmt(x,y-1)));
    //         }   
    //     }      
    // }

    // public static void fungsidxy(int bariskoef,Matrix  D)
    // {   int x=0,y=0;
    //     if (bariskoef%4==0){
    //         x=0;
    //         y=0;
    // }   else if (bariskoef%4==1) {
    //         x=0;
    //         y=1;
    //  }  else if (bariskoef%4==2) {
    //         x=1;
    //         y=0;
    //  }  else if (bariskoef%4==3) {
    //         x=1;
    //         y=1;
    //  }
    //     for (int j = -1; j < 3; j++) {
    //         for (int i = -1; i < 3; i++) {
    //             if (i!=x || j!=y) {
    //                 continue;
    //             }
    //             int colCoef = 4*(i+1) + j+2 -1;
    //             D.setElmt(bariskoef, colCoef, 4);
    //         }   
    //     }      
    // }


}
    