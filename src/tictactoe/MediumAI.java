package tictactoe;

public class MediumAI extends Player {

    protected MediumAI(char name) {
        super(name);
    }

    /**
     * Medium logic is as follows,
     * 1) If it already has two in a row and can win with one further move, it does so.
     * 2) If its opponent can win with one move, it plays the move necessary to block this.
     * 3) Otherwise, it makes a random move.
     */
    @Override
    public void makeMove(Board board) {
        System.out.println("Making move level \"medium\"");

        //1) If it already has two in a row and can win with one further move, it does so.
        if (canWin(board)) {
            board.print();
            return;
        }

        //2) If its opponent can win with one move, it plays the move necessary to block this.
        if (canBlock(board)) {
            board.print();
            return;
        }

        //3) make random move
        makeRandomMove(board);
    }

    private boolean canWin(Board board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isOpen(i, j)) {
                    board.playMove(name, i, j);

                    if (name == 'X' && board.xWins()) {
                        return true;
                    }

                    if (name == 'O' && board.oWins()) {
                        return true;
                    }

                    board.unPlayMove(i, j);
                }
            }
        }

        return false;
    }

    private boolean canBlock(Board board) {
        char otherPlayer = name == 'X' ? 'O' : 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isOpen(i, j)) {
                    board.playMove(otherPlayer, i, j);

                    if (otherPlayer == 'X' && board.xWins()) {
                        board.unPlayMove(i, j);
                        board.playMove(name, i, j);
                        return true;
                    }

                    if (otherPlayer == 'O' && board.oWins()) {
                        board.unPlayMove(i, j);
                        board.playMove(name, i, j);
                        return true;
                    }

                    board.unPlayMove(i, j);
                }
            }
        }

        return false;
    }
}
