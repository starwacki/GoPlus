package model;

public class Handicap   {
    private final static int FIRST_BOARD_CAPABLE_HANDICAP_SIZE = 9;
    private final static int SECOND_BOARD_CAPABLE_HANDICAP_SIZE = 13;
    private final static int THIRD_BOARD_CAPABLE_HANDICAP_SIZE = 19;
    private static final int MAX_HANDICAP_STONES_TO_FIRST_GROUP_OF_BOARDS = 5;
    private static final int MAX_HANDICAP_STONES_TO_SECOND_GROUP_OF_BOARDS = 9;
    private static final int MAX_HANDICAP_STONES_TO_THIRD_GROUP_OF_BOARDS = 9;
    private static final int MINIMAL_HANDICAP_STONES_VALUE = 0;
    private static final int BOARD_WIDTH_INDEX = 0;
    private final static int A_CHAR_VALUE = 65;
    private final static int Z_CHAR_VALUE = 90;
    private final static int MAX_LETTER_LENGTH =1;
    private final static int LETTER_INDEX = 0;
    private final static int CALCULATE_WIDTH_INDEX_VALUE = 64;
    private static final char BLACK_PLAYER_CHAR = 'x';
    private int stones;
    private char[][] board;

    public Handicap(int stones, char[][] board) {
        this.stones = stones;
        this.board = board;
        if (isBoardCanHandicap()) handicapByBoardDimensions(stones);
        else throw new IllegalArgumentException();
    }

    private void handicapByBoardDimensions(int stones) {
        if (isHandicapStonesCorrectValue(stones)) handicapStonesToBoard(stones);
        else throw new IllegalArgumentException();
    }

    private boolean isBoardCanHandicap() {
        return (board.length == FIRST_BOARD_CAPABLE_HANDICAP_SIZE && board[BOARD_WIDTH_INDEX].length == FIRST_BOARD_CAPABLE_HANDICAP_SIZE) ||
                (board.length == SECOND_BOARD_CAPABLE_HANDICAP_SIZE && board[BOARD_WIDTH_INDEX].length == SECOND_BOARD_CAPABLE_HANDICAP_SIZE) ||
                (board.length == THIRD_BOARD_CAPABLE_HANDICAP_SIZE && board[BOARD_WIDTH_INDEX].length == THIRD_BOARD_CAPABLE_HANDICAP_SIZE);
    }

    private void handicapStonesToBoard(int stones) {
        if (board.length == FIRST_BOARD_CAPABLE_HANDICAP_SIZE) handicapStonesToFirstGroupBoard(stones);
        if (board.length == SECOND_BOARD_CAPABLE_HANDICAP_SIZE) handicapStonesToSecondGroupBoard(stones);
        if (board.length == THIRD_BOARD_CAPABLE_HANDICAP_SIZE) handicapStonesToThirdGroupBoard(stones);

    }

    private void handicapStonesToThirdGroupBoard(int stones) {
        switch (stones) {
            case 1 -> put1HandicapStoneToThirdGroupBoard();
            case 2 -> put2HandicapStonesToThirdGroupBoard();
            case 3 -> put3HandicapStonesToThirdGroupBoard();
            case 4 -> put4HandicapStonesToThirdGroupBoard();
            case 5 -> put5HandicapStonesToThirdGroupBoard();
            case 6 -> put6HandicapStonesToThirdGroupBoard();
            case 7 -> put7HandicapStonesToThirdGroupBoard();
            case 8 -> put8HandicapStonesToThirdGroupBoard();
            case 9 -> put9HandicapStonesToThirdGroupBoard();
        }
    }

    private void put1HandicapStoneToThirdGroupBoard() {
        putStones("4P");
    }

    private void put2HandicapStonesToThirdGroupBoard() {
        put1HandicapStoneToThirdGroupBoard();
        putStones("16D");
    }

    private void put3HandicapStonesToThirdGroupBoard() {
        put2HandicapStonesToThirdGroupBoard();
        putStones("16P");
    }

    private void put4HandicapStonesToThirdGroupBoard() {
        put3HandicapStonesToThirdGroupBoard();
        putStones("4D");
    }

    private void put5HandicapStonesToThirdGroupBoard() {
        put4HandicapStonesToThirdGroupBoard();
        putStones("10J");
    }

    private void put6HandicapStonesToThirdGroupBoard() {
        put5HandicapStonesToThirdGroupBoard();
        putStones("10D");
    }

    private void put7HandicapStonesToThirdGroupBoard() {
        put6HandicapStonesToThirdGroupBoard();
        putStones("10P");
    }

    private void put8HandicapStonesToThirdGroupBoard() {
        put7HandicapStonesToThirdGroupBoard();
        putStones("4J");
    }

    private void put9HandicapStonesToThirdGroupBoard() {
        put8HandicapStonesToThirdGroupBoard();
        putStones("16J");
    }

    private void handicapStonesToSecondGroupBoard(int stones) {
        switch (stones) {
            case 1 -> put1HandicapStoneToSecondGroupBoard();
            case 2 -> put2HandicapStonesToSecondGroupBoard();
            case 3 -> put3HandicapStonesToSecondGroupBoard();
            case 4 -> put4HandicapStonesToSecondGroupBoard();
            case 5 -> put5HandicapStonesToSecondGroupBoard();
            case 6 -> put6HandicapStonesToSecondGroupBoard();
            case 7 -> put7HandicapStonesToSecondGroupBoard();
            case 8 -> put8HandicapStonesToSecondGroupBoard();
            case 9 -> put9HandicapStonesToSecondGroupBoard();
        }
    }

    private void put1HandicapStoneToSecondGroupBoard() {
        putStones("4J");
    }

    private void put2HandicapStonesToSecondGroupBoard() {
        put1HandicapStoneToSecondGroupBoard();
        putStones("10D");
    }

    private void put3HandicapStonesToSecondGroupBoard() {
        put2HandicapStonesToSecondGroupBoard();
        putStones("10J");
    }

    private void put4HandicapStonesToSecondGroupBoard() {
        put3HandicapStonesToSecondGroupBoard();
        putStones("4D");
    }

    private void put5HandicapStonesToSecondGroupBoard() {
        put4HandicapStonesToSecondGroupBoard();
        putStones("7G");
    }

    private void put6HandicapStonesToSecondGroupBoard() {
        put5HandicapStonesToSecondGroupBoard();
        putStones("7D");
    }

    private void put7HandicapStonesToSecondGroupBoard() {
        put6HandicapStonesToSecondGroupBoard();
        putStones("7J");
    }

    private void put8HandicapStonesToSecondGroupBoard() {
        put7HandicapStonesToSecondGroupBoard();
        putStones("4G");
    }

    private void put9HandicapStonesToSecondGroupBoard() {
        put8HandicapStonesToSecondGroupBoard();
        putStones("10G");
    }

    private void handicapStonesToFirstGroupBoard(int stones) {
        switch (stones) {
            case 1 -> put1HandicapStoneToFirstGroupBoard();
            case 2 -> put2HandicapStonesToFirstGroupBoard();
            case 3 -> put3HandicapStonesToFirstGroupBoard();
            case 4 -> put4HandicapStonesToFirstGroupBoard();
            case 5 -> put5HandicapStonesToFirstGroupBoard();

        }
    }

    private void put1HandicapStoneToFirstGroupBoard() {
        putStones("3G");
    }

    private void put2HandicapStonesToFirstGroupBoard() {
        put1HandicapStoneToFirstGroupBoard();
        putStones("7C");
    }

    private void put3HandicapStonesToFirstGroupBoard() {
        put2HandicapStonesToFirstGroupBoard();
        putStones("7G");
    }

    private void put4HandicapStonesToFirstGroupBoard() {
        put3HandicapStonesToFirstGroupBoard();
        putStones("3C");
    }

    private void put5HandicapStonesToFirstGroupBoard() {
        put4HandicapStonesToFirstGroupBoard();
        putStones("5E");
    }


    private void putStones(String coordinate) {
        board[getHeightMoveIndex(coordinate) - 1][getWidthMoveIndex(coordinate) - 1] = BLACK_PLAYER_CHAR;
    }

    private int getHeightMoveIndex(String move) {
        try {
            return Integer.parseInt(move.replaceAll("\\D",""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private int getWidthMoveIndex(String move) {
        if (isMovePropertyValue(move)) return getWidthIndexNumericValue(move);
        else throw new IllegalArgumentException();

    }

    private boolean isMovePropertyValue(String move) {
        char[] verticalTableValue = move.replaceAll("\\d","").toCharArray();
        return  verticalTableValue.length == MAX_LETTER_LENGTH &&
                verticalTableValue[LETTER_INDEX] >= A_CHAR_VALUE &&
                verticalTableValue[LETTER_INDEX] <= Z_CHAR_VALUE;
    }

    private int getWidthIndexNumericValue(String move) {
        return move.replaceAll("\\d","").charAt(LETTER_INDEX) - CALCULATE_WIDTH_INDEX_VALUE;
    }

    private boolean isHandicapStonesCorrectValue(int stones) {
        if (stones <= MINIMAL_HANDICAP_STONES_VALUE) throw new IllegalArgumentException();
        else if (board.length == FIRST_BOARD_CAPABLE_HANDICAP_SIZE)
            return stones <= MAX_HANDICAP_STONES_TO_FIRST_GROUP_OF_BOARDS;
        else if (board.length == SECOND_BOARD_CAPABLE_HANDICAP_SIZE)
            return stones <= MAX_HANDICAP_STONES_TO_SECOND_GROUP_OF_BOARDS;
        else return stones <= MAX_HANDICAP_STONES_TO_THIRD_GROUP_OF_BOARDS;
    }

}
