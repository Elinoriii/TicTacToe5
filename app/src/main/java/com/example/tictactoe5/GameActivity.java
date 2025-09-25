package com.example.tictactoe5;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {
    FBModule fbModule;
    Board board;
    GameModule gameModule;


    Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Board board = new Board(this);
        setContentView(board);
        fbModule = new FBModule(this);
        gameModule = new GameModule();
        }

    public void setPlayInGameActivity(Position position)
    {
        int row = position.getRow();
        int col = position.getCol();
        board.setNewValOnBoard(row,col);
        if (gameModule.iswin(board.getarr()) != 2)
            Toast.makeText(this, "win = " + gameModule.iswin(board.getarr()), Toast.LENGTH_SHORT).show();
    }
    public void setNewTouch (int row, int col)
    {
        Position position = new Position(row,col);
        fbModule.setPlayInFireBase(position);
    }
}
