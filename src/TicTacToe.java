import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

     Scanner in = new Scanner(System.in);

     private static int row;
     private static int col;
     private static int count;

     private static String player = "";
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rowMove = 0;
        int colMove = 0;
        boolean done = false;
        int moveCount = 1;
        boolean status = false;
        boolean restart = false;

        /**
         * •	Clear the board and set the player to X (since X always moves first)
         * •	get the coordinates for the move which should be 1 – 3 for the row and col
         * •	convert the player move coordinates to the array indices which are 0 – 2 by subtracting 1
         * •	loop until the converted player coordinates are a valid move
         * •	if appropriate check for a win or a tie (i.e. if it is possible for a win or a tie at this point in the game, check for it.)
         * •	If there is a win or tie announce it and then prompt the players to play again.
         * •	Toggle the player (i.e. X becomes O, O becomes X)
         */

        do {
            ClearBoard();
            player = "X";
            while (moveCount <= 9)
            {

                do {
                    rowMove = SafeInput.getRangedInt(in, "Enter the row move (1-3) ", 1, 3);
                    rowMove -= 1;
                    colMove = SafeInput.getRangedInt(in, "Enter the col move (1-3) ", 1, 3);
                    colMove -= 1;

                    done = isValidMove(rowMove, colMove);
                    if (done == true)
                    {
                        ;
                    }
                    else
                    {
                        System.out.println("Please enter your move on an empty space");
                    }
                } while (!done);
                    board[rowMove][colMove] = player;

//                    System.out.println(moveCount);
                    display();



                    if (moveCount >= 5 && moveCount <= 9)
                    {
                        if (isWin(player) || (isTie() && moveCount == 9)) {
                            announceResult();
                            restart = SafeInput.getYNConfirm(in, "Do you want to play again[Y/N]? ");
                            break;
                        }
                        else
                        {
                            moveCount += 1;
                            switch (moveCount)
                            {
                                case  3, 5, 7, 9 -> player = "X";
                                default -> player = "O";
                            }
                        }
                }
                else
                {
                    moveCount += 1;
                    switch (moveCount)
                    {
                        case  3, 5, 7, 9 -> player = "X";
                        default -> player = "O";
                    }
                }

//                System.out.println(moveCount);


            }
            moveCount = 1;
            System.out.println();
        } while (restart);

    }

    private static void ClearBoard()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] ="";
            }
        }
    }

    	private static void display() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++)
                    System.out.print("\t" + board[i][j]);

                System.out.println();
            }
        }

        private static boolean isValidMove( int row,int col)
        {
          boolean retVal = false;

            if (board[row][col].equals(""))
            retVal = true;

            return retVal;
        }

        private  static boolean isRowWin(String player)
        {
            for (int row = 0; row < ROW; row++)
            {
              if((board[row][0].equals(player)) && board[row][1].equals(player) && board[row][2].equals(player))
                return true;

            }

           return false;
        }

    private  static boolean isColWin(String player)
    {
        for (int col = 0; col < ROW; col++)
        {
            if((board[0][col].equals(player)) && board[1][col].equals(player) && board[2][col].equals(player))
                return true;

        }

       return false;
    }

    	private static boolean isDiagonalWin(String player)
    {
        if((board[0][0].equals(player)) && board[1][1].equals(player) && board[2][2].equals(player) || (board[0][2].equals(player)) && board[1][1].equals(player) && board[2][0].equals(player))
            return true;

        return false;
    }

    private static boolean isWin(String player)
    {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
          return true;
        }
        return false;
    }

    private static boolean isTie()
    {
        for (int i=0; i < board.length;i++)
        {
            for (int j=0; j < board.length; j++)
            {
                if (board[i][j].equals(" "))
                {
                    return false;
                }
            }

        }
        return true;
    }

    private static void announceResult() {
        if (isWin(player))
        {
            System.out.println("Player " + player + " wins!");
        } else if (isTie()) {
            System.out.println("It's a tie!");
        } else
        {
            ;
        }
    }




}