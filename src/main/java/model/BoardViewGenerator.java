package model;

public class BoardViewGenerator {
    private final static int A_CHAR_VALUE = 65;
    private final static int TABLE_STRING_PROPERTY_FORMAT_LIMIT = 10;
    char[][] board;
    private String boardView;

    public BoardViewGenerator(char[][] board) {
        this.board = board;
        this.boardView = createBoardView();
    }

    public String getBoardView() {
        return boardView;
    }

    private String createBoardView() {
        StringBuilder stringBuilder = new StringBuilder();
        createHorizontalRowForSize(stringBuilder);
        createBoardTemplate(stringBuilder);
        return stringBuilder.toString();
    }


    private void createHorizontalRowForSize(StringBuilder stringBuilder) {
        if (board.length<TABLE_STRING_PROPERTY_FORMAT_LIMIT)stringBuilder.append("  " + createHorizontalRow()+ "\n");
        else stringBuilder.append("   " + createHorizontalRow()+ "\n");
    }

    private void createBoardTemplate(StringBuilder stringBuilder) {
        for (int i = 0; i < board.length ; i++) {
            if (board.length<TABLE_STRING_PROPERTY_FORMAT_LIMIT) createStringTemplateForLessThan10Rows(stringBuilder,i);
            else createStringTemplateForMoreThan10Rows(stringBuilder,i);
            getBoardValue(stringBuilder,i);
            stringBuilder.append(board[i][board[i].length-1] + "\n");
        }
    }

    private void createStringTemplateForLessThan10Rows(StringBuilder stringBuilder, int i) {
         stringBuilder.append((board.length - i) + " ");
    }

    private void createStringTemplateForMoreThan10Rows(StringBuilder stringBuilder, int i) {
        if (board.length-i>=10) stringBuilder.append(board.length-i + " ");
        else stringBuilder.append((board.length-i) + "  ");
    }

    private void getBoardValue(StringBuilder stringBuilder, int i) {
        for (int j = 0; j < board[i].length-1; j++) {
            stringBuilder.append(board[i][j] + " ");
        }
    }

    //In Go game we ignored Big I because this is so similar to l;

    private String createHorizontalRow() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < board[0].length-1; i++) {
            createHorizontalRowLetters(getNextLetterFromAlphabet(i),stringBuilder);
        }
        createLastLetterToHorizontalRow(stringBuilder);
        return  stringBuilder.toString();
    }

    private void createLastLetterToHorizontalRow(StringBuilder stringBuilder) {
        if (isCharBiggerThanI(getLastLetter())) addLastLetterForLetterBiggerThanI(stringBuilder);
        else addLastLetterForLetterSmallerThanI(stringBuilder);
    }

    private void addLastLetterForLetterBiggerThanI(StringBuilder stringBuilder) {
        stringBuilder.append((char) (getLastLetter()+1));
    }

    private void addLastLetterForLetterSmallerThanI(StringBuilder stringBuilder) {
        stringBuilder.append(getLastLetter());
    }

    private char getLastLetter() {
        return ((char)(A_CHAR_VALUE+board[0].length-1));
    }

    private void createHorizontalRowLetters(char ch,StringBuilder stringBuilder) {
        if (isCharBiggerThanI(ch)) addBiggerThanILetterToHorizontalRow(stringBuilder,ch);
        else addSmallerThanILetterToHorizontalRow(stringBuilder,ch);
    }

    private void addBiggerThanILetterToHorizontalRow(StringBuilder stringBuilder, char ch) {
        ch += 1;
        stringBuilder.append(ch + " ");
    }

    private void addSmallerThanILetterToHorizontalRow(StringBuilder stringBuilder, char ch) {
        stringBuilder.append(ch + " ");
    }

    private boolean isCharBiggerThanI(char ch) {
        return ch >= 'I';
    }

    private char getNextLetterFromAlphabet(int i) {
        return (char) (A_CHAR_VALUE + i);
    }



}
