import java.util.Scanner;

public class ticTacToe extends arcade
{
    void rules()
    {
        System.out.println("RULES OF TIC-TAC-TOE (2 people):");
        System.out.println("1. The game is played on a grid that's 3 squares by 3 squares.");
        System.out.println("2. You are X, your friend is O. Players take turns putting their marks in empty squares.");
        System.out.println("3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.");
        System.out.println("4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.");
        System.out.println("5. Note that the players need to enter the coloumn and row number of their choice.");
    }
    
    void gamers()
    {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';
        boolean gameFinished = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameFinished) 
        {
            // Display the current game board
            displayBoard(board);

            // Ask the user for their move
            System.out.print("Player " + currentPlayer + ", enter row (1-3): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Player " + currentPlayer + ", enter column (1-3): ");
            int col = scanner.nextInt() - 1;

            // Check if the move is valid
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') 
            {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            // Update the game board with the player's move
            board[row][col] = currentPlayer;

            // Check if the game's been won or if there is a tie
            if (checkWin(board, currentPlayer)) 
            {
                displayBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameFinished = true;
            } 
            else if (checkTie(board)) 
            {
                displayBoard(board);
                System.out.println("It's a tie!");
                gameFinished = true;
            }

            // Switch to the other player's turn
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
    
    boolean game(){return true;}
     void displayBoard(char[][] board) 
     {
        System.out.println("\n  1 2 3");
        for (int i = 0; i < board.length; i++) 
        {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < board[i].length; j++) 
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }   
    
    boolean checkWin(char[][] board, char player) 
    {
        for (int i = 0; i < 3; i++) 
        {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) 
            {
                return true; // horizontal win
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) 
            {
                return true; // vertical win
            }
        }
        if (board[0][0] == player && board [1][1] == player && board[2][2] == player) 
        {
            return true; // diagonal win
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) 
        {
            return true; // diagonal win
        }
        return false;
    }
    
    boolean checkTie(char[][] board) {
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[i].length; j++) 
            {
                if (board[i][j] == ' ') 
                {
                    return false; // game is not over
                }
            }
        }
        return true;
    }
    
    public static void main(String []ar)
    {
        ticTacToe obj = new ticTacToe();
        obj.rules();
        obj.gamers();
    }
}