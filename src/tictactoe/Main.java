package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //game runs with three parameters
        //computer settings - (easy, medium, hard)
        //user - play as a user
        //exit - stop app
        //ex: start user hard -> play against hard computer
        //ex: start hard hard -> have computer play against itself
        //ex: exit -> stop app

        Scanner scanner = new Scanner(System.in);
        GameController controller = new GameController(scanner);
        controller.playGame();
    }
}
