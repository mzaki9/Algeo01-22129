package matrix;

//tes
public class Matrix {
    public int row, col;
    public double[][] Matrix;

    /* Constructor */
    public Matrix(int row, int col){
        this.row = row;
        this.col = col;
        this.Matrix = new double[row][col];
    }
    public double getElmt(int i, int j){
        return this.Matrix[i][j];
    }
    public int getRowEff(){
        return this.row;
    }
    public int getColEff(){
        return this.col;
    }
    public void setElmt(int i, int j, double x){
        this.Matrix[i][j] = x;
    }
    
}
