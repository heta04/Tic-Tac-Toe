import java.util.Scanner;

class HumanPlayer extends player
{
    public HumanPlayer(final board board, final int n, final String s) {
        super(board, n, s);
    }
    
    @Override
    public void play(final board gameBoard) {
        final Scanner scanner = new Scanner(System.in);
        super.gameBoard = gameBoard;
        boolean move;
        do {
            System.out.println("Please enter your move by selecting a number from the available moves: ");
            gameBoard.displaymainboard();
            move = gameBoard.makeMove(scanner.nextInt(), this.playerSymbol);
            if (!move) {
                System.out.println("Invalid move! try again...");
            }
        } while (!move);
    }
}