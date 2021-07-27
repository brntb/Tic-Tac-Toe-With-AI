package tictactoe;

import java.util.Scanner;

public class GameController {

    private final Board board;
    private final Scanner scanner;
    private Player playerOne;
    private Player playerTwo;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
        this.board = new Board();
    }

    public void playGame() {

        while (setGameParameters()) {
            //parameters were set, now actually loop through game until finished
            while (true) {
                //player one turn
                playerOne.makeMove(board);
                if (board.xWins()) {
                    System.out.println("X wins\n");
                    break;
                } else if (board.isDraw()) {
                    System.out.println("Draw\n");
                    break;
                }

                //player two turn
                playerTwo.makeMove(board);
                if (board.oWins()) {
                    System.out.println("O wins\n");
                    break;
                } else if (board.isDraw()) {
                    System.out.println("Draw\n");
                    break;
                }
            }

            //loop broke so game is over, need to clear board for new round
            board.init();
        }

    }

    /**
     * returns true if parameters set
     * returns false if user wants to exit
     */
    private boolean setGameParameters() {
        while (true) {
            System.out.print("Input command: ");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.contains("exit")) {
                return false;
            }

            String[] holder = input.split("\\s+");

            if (holder.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }

            //set player one
            if ("user".equals(holder[1])) {
                playerOne = new HumanPlayer('X', scanner);
            } else if ("easy".equals(holder[1])) {
                playerOne = new EasyAI('X');
            } else if ("medium".equals(holder[1])) {
                playerOne = new MediumAI('X');
            } else if ("hard".equals(holder[1])) {
                playerOne = new HardAI('X');
            } else {
                System.out.println("Error! Unknown first parameter. Try again!");
                continue;
            }

            //set player two
            if ("user".equals(holder[2])) {
                playerTwo = new HumanPlayer('O', scanner);
            } else if ("easy".equals(holder[2])) {
                playerTwo = new EasyAI('O');
            } else if ("medium".equals(holder[2])) {
                playerTwo = new MediumAI('O');
            } else if ("hard".equals(holder[2])) {
                playerTwo = new HardAI('O');
            } else {
                System.out.println("Error! Unknown second parameter. Try again!");
                continue;
            }

            board.print();
            break;
        }

        return true;
    }

}
