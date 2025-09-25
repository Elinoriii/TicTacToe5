package com.example.tictactoe5;

public class Position {
    private int row, col;
    public Position ()
    {

    }
    public Position(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    public int getCol()
    {
        return col;
    }
    public int getRow()
    {
        return row;
    }
    public void setRow(int row)
    {
        this.row = row;
    }
    public void setCol(int col)
    {
        this.col = col;
    }
}
