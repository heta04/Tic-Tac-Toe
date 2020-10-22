import java.util.Random;

public class AIPlayer extends player implements global
{
    public AIPlayer(final board board, final int n, final String s) {
        super(board, n, s);
    }
    
    @Override
    public void play(final board board) {
        final int random = this.random();
        board.makeMove(random, this.playerSymbol);
        System.out.println(this.playerName + ": My move is at  " + random+"\n");
    }
       
    private int random() {
        int bound = 0;
        final int[] array = new int[9];
        final Random random = new Random();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (this.gameBoard.blocks[i][j].getState() == 0) {
                    array[bound++] = 3 * i + 1 + j;
                }
            }
        }
        return array[random.nextInt(bound)];
    }
}
