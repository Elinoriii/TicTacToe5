package com.example.tictactoe5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class Board extends View {
    private Cell[][] arr;
    private int canvaswidth;
    private int cellwidth, cellhigh;
    private  int count = 0;
    private boolean  firsttime;
    GameModule game;
    private Context context;

    public Board(Context context)
    {
        super(context);
        this.context = context;
        this.arr = new  Cell[5][5];
        this.firsttime = true;
        game = new GameModule();
    }

    @Override
    protected void onDraw( Canvas canvas) {
        super.onDraw(canvas);
        if (firsttime)
        {
            canvaswidth = canvas. getWidth();
            cellwidth = canvaswidth / 5;
            cellhigh = cellwidth;
            Bitmap picx = BitmapFactory.decodeResource(getResources(),R.drawable.x);
            Bitmap pico = BitmapFactory.decodeResource(getResources(),R.drawable.o);
            picx = Bitmap.createScaledBitmap(picx,cellwidth - 10, cellhigh - 10, false);
            pico = Bitmap.createScaledBitmap(pico, cellwidth - 10, cellhigh - 10, false);
            for (int i = 0; i < 5; i++)
            {
                for (int k = 0; k < 5; k++)
                {
                    arr[i][k] = new Cell( k * cellwidth, i * cellhigh, cellwidth, picx, pico);
                }
            }
            this.firsttime = false;
        }
        for (int i = 0; i < 5; i++)
        {
            for (int k = 0; k < 5; k++)
            {
                arr[i][k].Draw(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int i = (int) y / cellwidth;
        int k = (int) x / cellhigh;
        if (i < 5 && k < 5)
        {
            if (arr[i][k].IsEmpty()) {
                setNewValOnBoard(i, k);
                if (game.iswin(arr) == 1) {
                    Toast.makeText(this.getContext(), "o win", Toast.LENGTH_SHORT).show();
                    return true;
                }
                if (game.iswin(arr) == 0) {
                    Toast.makeText(this.getContext(), "x win", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
            else
            {
                Toast.makeText(this.getContext(), "not empty", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this.getContext(), "outside board", Toast.LENGTH_SHORT).show();
            return false;
        }
        return false;
    }

    private void setNewValOnBoard(int i, int k)
    {
          if (arr[i][k]. setval(count) == true) {
              count = 1 - count;
              invalidate();
          }
    }
    public Cell[][] getarr()
    {
        return arr;
    }
}
