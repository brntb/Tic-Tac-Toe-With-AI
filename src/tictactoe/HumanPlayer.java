package tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private final Scanner scanner;

    public HumanPlayer(char name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public void makeMove(Board board) {
        int[] coordinates = getCoordinates(board);
        board.playMove(name, coordinates[0], coordinates[1]);
        board.print();
    }


    /**
     * Validates input to make sure user entered two numbers from 1 - 3
     * returns an array of the moves if valid
     */
    private int[] getCoordinates(Board board) {
        int[] moves = new int[2];

        while (true) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine().trim();
            String[] holder = input.split("\\s+");

            //check for two coordinates
            if (holder.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            //check that coordinates aren't letters
            if (holder[0].matches("[a-zA-Z]+") || holder[1].matches("[a-zA-Z]+")) {
                System.out.println("You should enter numbers!");
                continue;
            }

            //check that both coordinates are numbers from 1 - 3
            if (!holder[0].matches("[1-3]") || !holder[1].matches("[1-3]")) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            //at this point we have two string coordinates from 1 - 3, parse to in
            //subtract 1 to make sense to java
            moves[0] = Integer.parseInt(holder[0]) - 1;
            moves[1] = Integer.parseInt(holder[1]) - 1;

            //make sure move is not already played
            if (!board.isOpen(moves[0], moves[1])) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            break;
        }

        return moves;
    }
}
