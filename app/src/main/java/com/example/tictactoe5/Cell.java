package com.example.tictactoe5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Cell {
    private int xmouse;
    private int ymouse;
    private int xcell, ycell;
    private int oval = 1;
    private int xval = 0;
    private int empty =2 ;
    private int val ;
    private int cellwidth;
   private Bitmap picx,pico;
    private Paint p;
    public Cell(int xcell, int ycell, int cellwidth, Bitmap picx, Bitmap pico)
    {
        this.xcell = xcell;
        this.p = new Paint();
        this.ycell = ycell;
        this.val = empty;
        this.cellwidth = cellwidth;
        this.picx = picx;
        this.pico = pico;

    }
    public void Draw(Canvas canvas)
    {
        p.setStrokeWidth(15);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawRect(xcell, ycell, xcell + cellwidth, ycell + cellwidth, p);
        if (val == xval)
            canvas.drawBitmap(picx, xcell + 10, ycell + 10, null);
        if (val == oval)
            canvas.drawBitmap(pico, xcell + 10, ycell + 10, null);
    }
    public boolean setval(int val)
    {
        if (this.val == empty)
        {
            this.val = val;
            return true;
        }
        return false;
    }

    public int getVal()
    {
        return val;
    }
    public boolean IsEmpty()
    {
      return this.val == empty;
    }
}
