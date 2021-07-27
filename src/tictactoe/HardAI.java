package tictactoe;

public class HardAI extends Player {

    private final char other;

    protected HardAI(char name) {
        super(name);
        other = name == 'X' ? 'O' : 'X';
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Making move level \"hard\"");

        int bestScore = Integer.MIN_VALUE;
        int bestI = 0;
        int bestJ = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isOpen(i, j)) {
                    board.playMove(name, i, j);
                    int score = minimax(board, 0 ,false);
                    board.unPlayMove(i, j);
                    if (score > bestScore) {
                        bestScore = score;
                        bestI = i;
                        bestJ = j;
                    }

                }
            }
        }

        board.playMove(name, bestI, bestJ);
        board.print();
    }

    private int minimax(Board board, int depth, boolean isMaximizing) {
        if (name == 'X' && board.xWins()) {
            return 10;
        } else if (name == 'X' && board.oWins()) {
            return -10;
        } else if (name == 'O' && board.oWins()) {
            return 10;
        } else if (name == 'O' && board.xWins()) {
            return -10;
        } else if (board.isDraw()) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.isOpen(i, j)) {
                        board.playMove(name, i, j);
                        bestScore = Math.max(bestScore, minimax(board, depth + 1, false));
                        board.unPlayMove(i, j);
                    }
                }
            }

            return bestScore;

        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.isOpen(i, j)) {
                        board.playMove(other, i, j);
                        bestScore = Math.min(bestScore, minimax(board, depth + 1, true));
                        board.unPlayMove(i, j);
                    }
                }
            }

            return bestScore;
        }
    }

}
