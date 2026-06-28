package org.example;

public class Board {

    private final char[] cells;

    public Board() {
        cells = new char[9];

        for (int i = 0; i < 9; i++) {
            cells[i] = (char) ('1' + i);
        }
    }

    public void display() {
        System.out.println();

        for (int i = 0; i < 9; i += 3) {
            System.out.printf(" %c | %c | %c%n", cells[i], cells[i + 1], cells[i + 2]);

            if (i < 6)
                System.out.println("-----+-----+-----");
        }

        System.out.println();
    }

    public boolean makeMove(int position, char symbol) {

        if (position < 1 || position > 9)
            return false;

        if (cells[position - 1] == 'X' || cells[position - 1] == 'O')
            return false;

        cells[position - 1] = symbol;
            return true;

    }

    public boolean isFull() {

        for (char c : cells) {
            if (c != 'X' && c != 'O')
                return false;
        }

        return true;
    }

    public boolean checkWinner(char symbol) {

        int[][] wins = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6},
        };

        for (int[] win : wins) {
            if (cells[win[0]] == symbol && cells[win[1]] == symbol && cells[win[2]] == symbol)
                return true;
        }

        return false;
    }



}
