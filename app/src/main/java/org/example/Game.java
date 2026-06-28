package org.example;

import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean playAgain = true;

        while (playAgain) {

            Board board = new Board();

            Player playerX = new Player('X');
            Player playerO = new Player('O');

            Player current = playerX;

            boolean gameOver = false;

            while (!gameOver) {
                board.display();

                int move = getMove();

                if (!board.makeMove(move, current.getSymbol())) {
                    System.out.println("That is not a valid move! Try again.");
                    continue;
                }

                if (board.checkWinner(current.getSymbol())) {
                    board.display();

                    System.out.println("Player " + current.getSymbol() + " wins!");

                    gameOver = true;
                } else if (board.isFull()) {
                    board.display();

                    System.out.println("It's a draw!");

                    gameOver = true;
                } else {
                    current = (current == playerX) ? playerO : playerX;
                }
            }

            playAgain = askPlayAgain();
        }

        System.out.println("Goodbye!");
    }

    private int getMove() {
        while(true) {
            System.out.println("Player move: ");

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("That is not a valid move! Try again: ");
                continue;
            }

            try {
                int move = Integer.parseInt(input);

                return move;

            } catch (NumberFormatException e) {

                System.out.println("That is not a valid move! Try again: ");
            }
        }
    }

    private boolean askPlayAgain() {
        while (true) {

            System.out.println("Would you like to play again (yes/no)? ");

            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "yes":
                case "y":
                    return true;

                case "no":
                case "n":
                    return false;

                default:
                    System.out.println("That is not a valid input!");
            }
        }
    }
}
