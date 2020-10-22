import java.util.Random;
import java.util.Scanner;

class game implements global
{
    board gameBoard;
    player playerX;
    player playerO;
    int turn;
    boolean status;
    
    public game() {
        this.status = false;
        final Scanner scanner = new Scanner(System.in);
        this.gameBoard = new board();
        String s = "player1";
        String str = "player2";
        int Type = 0;
        System.out.println("*****************************************");
        System.out.println("\tWelcome to the world of \n\t\tTic Tac Toe");
        System.out.println("*****************************************");
        
        while (!this.status) {
            System.out.println(" Please select a game option:\n [1] Human vs Human\n [2] Human vs AI\n [3] AI vs AI");
            Type = scanner.nextInt();
            switch (Type) {
                case 1: {
                    System.out.print("Please enter Player 1 name : ");
                    s = scanner.next().trim();
                    System.out.println(s+" your symbol is X\n");
                    System.out.print("Please enter Player 2 name : ");
                    str = scanner.next().trim();
                    System.out.println(str+" your symbol is O\n");
                    
                    this.status = true;
                    continue;
                }
                case 2: {
                    System.out.print(" Please enter Player 1 name : ");
                    s = scanner.next().trim();
                    System.out.println(s+" your symbol is X");
                    
                    System.out.print(" Please enter AI player 2 name: ");
                    str=scanner.next().trim();
                    System.out.println(str+" your symbol is O");
                    
 
                    this.status = true;
                    continue;
                }
                case 3: {
                    System.out.print("Please enter  AI player 1 name: ");
                    s = scanner.next().trim();
                    System.out.println(s+" your symbol is X");
                    
                    System.out.print("Please enter  AI player 2 name: ");
                    str = scanner.next().trim();
                    System.out.println(str+" your symbol is O");
                    
                    this.status = true;
                    continue;
                }
                default: {
                    System.out.println("Please enter a valid selection...");
                    continue;
                }
            }
        }
        if (Type == 1) {
            this.playerX = new HumanPlayer(this.gameBoard, 1, s);
            this.playerO = new HumanPlayer(this.gameBoard, 2, str);
        }
        else if (Type == 2) {
            this.playerX = new HumanPlayer(this.gameBoard, 1, s);
            this.playerO = new AIPlayer(this.gameBoard, 2, str);
        }
        else {
            this.playerX = new AIPlayer(this.gameBoard, 1, s);
            this.playerO = new AIPlayer(this.gameBoard, 2, str);
        }
        System.out.println("Game initiated: " + s + " VS. " + str + "\n");
    }
    
    public void start() {
        final Random random = new Random();
        int i = 0;
        this.turn = random.nextInt(2) + 1;
        if (this.turn == 1) {
            System.out.println(" " + this.playerX.playerName + " wins the coin toss... \n");
        }
        else {
            System.out.println(" " + this.playerO.playerName + " wins the coin toss... \n");
        }
        while (i == 0) {
            if (this.turn == 1) {
                System.out.println(this.playerX+" Go ahead with X");
                this.playerX.play(this.gameBoard);
            }
            else {
                System.out.println(this.playerO+" Go ahead with O");
                   this.playerO.play(this.gameBoard);
            }
            if (this.gameBoard.getState() != 0) {
                i = 1;
            }
            if (i == 0) {
                if (this.turn == 1) {
                    this.turn = 2;
                }
                else {
                    this.turn = 1;
                }
            }
        }
        this.gameBoard.displayfinalboard();
        if (this.gameBoard.getState() == 3) {
            System.out.println(" It is a DRAW! no winner...");
        }
        else if (this.turn == 1) {
            System.out.println(" The winner is player " + this.playerX);
        }
        else {
            System.out.println(" The winner is player " + this.playerO);
        }
    }
}