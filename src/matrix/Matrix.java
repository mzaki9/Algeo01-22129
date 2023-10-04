package matrix;


public class Matrix {
    public int row, col;
    public double[][] Matrix;

    // Constructor Class Matriks
    public Matrix(int row, int col){
        this.row = row;
        this.col = col;
        this.Matrix = new double[row][col];
    }


    
    //Getter untuk Class Matrix
    public double getElmt(int i, int j){
        return this.Matrix[i][j];
    }
    public int getRowEff(){
        return this.row;
    }
    public int getColEff(){
        return this.col;
    }



    //Setter untuk class Matrix
    public void setElmt(int i, int j, double x){
        this.Matrix[i][j] = x;
    }
    
}
