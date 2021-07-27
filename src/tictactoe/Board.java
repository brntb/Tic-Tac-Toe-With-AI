package tictactoe;

import java.util.Arrays;

public class Board {

    private final char[][] board;

    public Board() {
        this.board = new char[3][3];
        init();
    }

    public void playMove(char player, int x, int y) {
        board[x][y] = player;
    }

    public void unPlayMove(int x, int y) {
        board[x][y] = ' ';
    }

    public boolean xWins() {
        return checkWinner() == 'X';
    }

    public boolean oWins() {
        return checkWinner() == 'O';
    }


    public boolean isDraw() {
        return checkWinner() == '!';
    }

    /**
     * returns 'X' or 'O' if there is a winner
     * returns ' ' if game is still playing
     * returns '!' if game is tie
     */
    private char checkWinner() {
        char winner = ' ';

        //check rows
        for (int i = 0; i < 3; i++) {
            if (hasThreeInRow(board[i][0], board[i][1], board[i][2])) {
                winner = board[i][0];
                break;
            }
        }

        //check vertical
        for (int i = 0; i < 3; i++) {
            if (hasThreeInRow(board[0][i], board[1][i], board[2][i])) {
                winner = board[0][i];
                break;
            }
        }

        //check diagonals
        if (hasThreeInRow(board[0][0], board[1][1], board[2][2])) {
            winner = board[0][0];
        } else if (hasThreeInRow(board[0][2], board[1][1], board[2][0])) {
            winner = board[0][2];
        }

        //check for tie
        int open = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    open++;
                }
            }
        }

        if (winner == ' ' && open == 0) {
            return '!';
        } else {
            return winner;
        }
    }

    private boolean hasThreeInRow(char a, char b, char c) {
        return a == b && b == c && a != ' ';
    }

    public boolean isOpen(int x, int y) {
        return board[x][y] == ' ';
    }

    public void init() {
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }


    public void print() {
        System.out.println("---------\n" +
                "| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |\n" +
                "| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |\n" +
                "| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |\n" +
                "---------");
    }

}
