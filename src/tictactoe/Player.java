package tictactoe;

import java.util.Random;

public abstract class Player {

    protected final char name;
    private final Random random;

    protected Player(char name) {
        this.name = name;
        this.random = new Random();
    }

    public abstract void makeMove(Board board);

    public void makeRandomMove(Board board) {
        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);

            if (board.isOpen(x, y)) {
                board.playMove(name, x, y);
                break;
            }
        }

        board.print();
    }

}
