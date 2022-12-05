package model;

import model.MoveTurn;

public class Move {
    private String move;
    private MoveTurn moveTurn;
    private String boardBeforeThisMove;

    public Move(String move, MoveTurn moveTurn,String actualBoard) {
        this.move = move;
        this.moveTurn = moveTurn;
        this.boardBeforeThisMove = actualBoard;
    }

    public String getMove() {
        return move;
    }

    public MoveTurn getMoveTurn() {
        return moveTurn;
    }

    public String getBoardBeforeThisMove() {
        return boardBeforeThisMove;
    }

    @Override
    public String toString() {
        return "Move{" +
                "move='" + move + '\'' +
                ", moveTurn=" + moveTurn +
                '}';
    }

    public char[][] parseActualTableStringToBoardTable() {
      String[] tableValues = getTableValuesToString();
      return getCharFromTableValues(tableValues);
    };

    private String[] getTableValuesToString() {
       return boardBeforeThisMove.replaceAll("[A-Z1=0-9\s]","").replaceFirst("\n","").split("\n");
    }

    private char[][] getCharFromTableValues(String[] tableValues) {
        char[][] tableChar = new char[getHeight(tableValues)][getWidth(tableValues)];
        putValuesIntoCharTable(tableChar,tableValues);
        return tableChar;
    }

    private int getWidth(String[] tableValues) {
        return tableValues[0].length();
    }

    private int getHeight(String[] tableValues) {
        return tableValues.length;
    }

    private void putValuesIntoCharTable(char[][] charTable,String[] tableValues) {
        for (int i = 0; i < charTable.length; i++) {
            for (int j = 0; j < charTable[i].length; j++) {
                charTable[i][j] = tableValues[i].toCharArray()[j];
            }
        }
    }

}
