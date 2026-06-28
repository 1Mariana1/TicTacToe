package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test
  void testBoardStartsNotFull() {

    Board board = new Board();

    assertFalse(board.isFull());
  }

  @Test
  void testValidMove() {
    Board board = new Board();

    assertTrue(board.makeMove(5, 'X'));
  }

  @Test
  void testTakenCell() {

    Board board = new Board();

    board.makeMove(1, 'X');

    assertFalse(board.makeMove(1, 'O'));
  }

  @Test
  void testInvalidPositionLow() {

    Board board = new Board();

    assertFalse(board.makeMove(0, 'X'));
  }

  @Test
  void testInvalidPositionHigh() {

    Board board = new Board();

    assertFalse(board.makeMove(10, 'X'));
  }

  @Test
  void testWinnerRow() {

    Board board = new Board();

    board.makeMove(1, 'X');
    board.makeMove(2, 'X');
    board.makeMove(3, 'X');

    assertTrue(board.checkWinner('X'));
  }

  @Test
  void testNoWinner() {

    Board board = new Board();

    board.makeMove(1, 'X');
    board.makeMove(2, 'O');

    assertFalse(board.checkWinner('X'));
  }

  @Test
  void testBoardFull() {

    Board board = new Board();

    char[] moves = {'X','O','X','O','X','O','X','O','X'};

    for (int i = 0; i < 9; i++) {
      board.makeMove(i + 1, moves[i]);
    }

    assertTrue(board.isFull());
  }

}
