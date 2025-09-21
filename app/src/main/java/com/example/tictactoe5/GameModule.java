package com.example.tictactoe5;

public class GameModule {
    //public static int xwin = 0;
    //public static  int owin = 1;

    public int iswin(Cell [][] arr)
    {
        for (int k = 0; k < 5; k++)
        {
            for (int i = 0; i < 2; i++)
            {
                if (arr[i][k] == arr[i+1][k] == arr[i+2][k] == arr[i+3][k])
                    return 1;

            }


        }
            }
        }
    }
}
