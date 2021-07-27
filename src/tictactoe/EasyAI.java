package tictactoe;

public class EasyAI extends Player {

    public EasyAI(char name) {
        super(name);
    }

    //just randomly picks an open spot of the board
    public void makeMove(Board board) {
        System.out.println("Making move level \"easy\"");
        makeRandomMove(board);
    }

}
