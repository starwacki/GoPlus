package model;

import java.util.ArrayList;
import java.util.List;

public class BoardGroupingAlgorithm {
    private final static int A_CHAR_VALUE = 65;
    private final static int Z_CHAR_VALUE = 90;
    private final static int MAX_LETTER_LENGTH = 1;
    private final static int LETTER_INDEX = 0;
    private final static int CALCULATE_WIDTH_INDEX_VALUE = 64;
    private int height;
    private int width;
    private List<WhiteCharsGroup> whiteGroups;
    private List<BlackCharsGroup> blackGroups;
    private List<String> listOfWhiteCharsCoordinates;
    private List<String> listOfBlackCharsCoordinates;


    public BoardGroupingAlgorithm( int height, int width,
            List<String> listOfWhiteCharsCoordinates, List<String> listOfBlackCharsCoordinates) {
        this.height = height;
        this.width = width;
        this.listOfWhiteCharsCoordinates = listOfWhiteCharsCoordinates;
        this.listOfBlackCharsCoordinates = listOfBlackCharsCoordinates;
        whiteGroups = new ArrayList<>();
        blackGroups = new ArrayList<>();
        addWhiteBlackCharsToGroups();
    }

    public List<WhiteCharsGroup> getWhiteGroups() {
        return whiteGroups;
    }

    public List<BlackCharsGroup> getBlackGroups() {
        return blackGroups;
    }

    private void addWhiteBlackCharsToGroups() {
        addWhiteCharsToGroups();
        addBlackCharsToGroups();
    }


    protected int getHeightMaxIndexInTable() {
        return height-1;
    }

    protected int getIndexInTable(int moveIndex) {
        return moveIndex-1;
    }
    protected int getHeightMoveIndex(String move) {
        try {
            return height-Integer.parseInt(move.replaceAll("\\D",""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected int getWidthMoveIndex(String move) {
        if (isMovePropertyValue(move)) return getWidthIndexNumericValue(move);
        else throw new IllegalArgumentException();
    }

    protected int getWidthMaxIndexInTable() {
        return width-1;
    }


    private void addCharToGroup(List<String> group,List<String> listWithActualCharsCoordinates,String move) {
        group.add(move);
        listWithActualCharsCoordinates.remove(move);
        addCharsToGroupIncludingLocation(getHeightMoveIndex(move),getIndexInTable(getWidthMoveIndex(move)),group,listWithActualCharsCoordinates);
    }

    private void addWhiteCharsToGroups() {
        List<String> listOfWhiteChars =new ArrayList<>(listOfWhiteCharsCoordinates);
        while (listOfWhiteChars.size()!=0) {
            List<String> newGroupOfChars = new ArrayList<>();
            addCharToGroup(newGroupOfChars,listOfWhiteChars,listOfWhiteChars.get(0));
            whiteGroups.add(new WhiteCharsGroup(newGroupOfChars));
        }
    }

    private void addBlackCharsToGroups() {
        List<String> listOfBlackChars = new ArrayList<>(listOfBlackCharsCoordinates);
        while (listOfBlackChars.size()!=0) {
            List<String> newGroupOfChars = new ArrayList<>();
            addCharToGroup(newGroupOfChars,listOfBlackChars,listOfBlackChars.get(0));
            blackGroups.add(new BlackCharsGroup(newGroupOfChars));
        }
    }

    private void addCharsToGroupIncludingLocation(int moveHeightCoordinate, int moveWidthCoordinate,List<String> group,List<String> listWithActualCharsCoordinates) {
    checkUpperCellBelongsToGroup(moveHeightCoordinate,moveWidthCoordinate,group,listWithActualCharsCoordinates);
    checkUnderCellBelongsToGroup(moveHeightCoordinate,moveWidthCoordinate,group,listWithActualCharsCoordinates);
    checkRightCellBelongsToGroup(moveHeightCoordinate,moveWidthCoordinate,group,listWithActualCharsCoordinates);
    checkLeftCellBelongsToGroup(moveHeightCoordinate,moveWidthCoordinate,group,listWithActualCharsCoordinates);
    }

    private void checkUpperCellBelongsToGroup(int moveHeightCoordinate, int moveWidthCoordinate,List<String> group,List<String> listWithActualCharsCoordinates) {
        if (isUpperCellExist(moveHeightCoordinate))
            if (checkListContain(listWithActualCharsCoordinates,getWantedChar(getHeightCoordinateToStringForm(moveHeightCoordinate-1),moveWidthCoordinate))) {
                addCharToGroup(group, listWithActualCharsCoordinates, getWantedChar(getHeightCoordinateToStringForm(moveHeightCoordinate-1), moveWidthCoordinate));
            }
    }

    private void checkUnderCellBelongsToGroup(int moveHeightCoordinate, int moveWidthCoordinate,List<String> group,List<String> listWithActualCharsCoordinates) {
        if (isUnderCellExist(moveHeightCoordinate))
            if (checkListContain(listWithActualCharsCoordinates,getWantedChar(getHeightCoordinateToStringForm(moveHeightCoordinate+1),moveWidthCoordinate))) {
                addCharToGroup(group, listWithActualCharsCoordinates, getWantedChar(getHeightCoordinateToStringForm(moveHeightCoordinate+1), moveWidthCoordinate));
            }

    }

    private void checkRightCellBelongsToGroup(int moveHeightCoordinate, int moveWidthCoordinate,List<String> group,List<String> listWithActualCharsCoordinates) {
        if (isRightCellExist(moveWidthCoordinate))
            if (checkListContain(listWithActualCharsCoordinates,getWantedChar(getHeightCoordinateToStringForm(moveHeightCoordinate),moveWidthCoordinate+1))) {
                addCharToGroup(group, listWithActualCharsCoordinates, getWantedChar(getHeightCoordinateToStringForm(moveHeightCoordinate), moveWidthCoordinate + 1));
            }

    }

    private void checkLeftCellBelongsToGroup(int moveHeightCoordinate, int moveWidthCoordinate,List<String> group,List<String> listWithActualCharsCoordinates) {
        if (isLeftCellExist(moveWidthCoordinate))
            if (checkListContain(listWithActualCharsCoordinates,getWantedChar(getHeightCoordinateToStringForm(moveHeightCoordinate),moveWidthCoordinate-1))) {
                addCharToGroup(group, listWithActualCharsCoordinates, getWantedChar(getHeightCoordinateToStringForm(moveHeightCoordinate), moveWidthCoordinate-1));
            }
    }

    private boolean checkListContain(List<String> listOfBlackCoordinates, String coordinate) {
        return listOfBlackCoordinates.contains(coordinate);
    }

    private boolean isUpperCellExist(int moveHeightCoordinate) {
        return moveHeightCoordinate > 0;
    }

    private boolean isUnderCellExist(int moveHeightCoordinate) {
        return moveHeightCoordinate < getHeightMaxIndexInTable();
    }

    private boolean isRightCellExist(int moveWidthCoordinate) {
        return moveWidthCoordinate < getWidthMaxIndexInTable();
    }

    private boolean isLeftCellExist(int moveWidthCoordinate) {
        return moveWidthCoordinate > 0;
    }

    private String getWantedChar(int moveHeightCoordinate, int moveWidthCoordinate ) {
        return  changeBoardIndexesToMoveStringForm(moveHeightCoordinate,moveWidthCoordinate);
    }

    private String changeBoardIndexesToMoveStringForm(int heightIndex, int widthIndex) {
        return String.valueOf(heightIndex) + (getHorizontalCoordinate(widthIndex));
    }

    private char getHorizontalCoordinate(int j) {
        if (isCoordinateBiggerThanICoordinate(j))
            return  getHorizontalCoordinateForCoordinateBiggerThanICoordinate(j);
        else
            return getHorizontalCoordinateForCoordinateSmallerThanICoordinate(j);
    }

    private boolean isCoordinateBiggerThanICoordinate(int j) {
        return j >7;
    }

    private char getHorizontalCoordinateForCoordinateBiggerThanICoordinate(int j) {
        return (char)(A_CHAR_VALUE+j+1);
    }

    private char getHorizontalCoordinateForCoordinateSmallerThanICoordinate(int j) {
        return (char)(A_CHAR_VALUE+j);
    }

    private boolean isMovePropertyValue(String move) {
        char[] verticalTableValue = move.replaceAll("\\d","").toCharArray();
        return  verticalTableValue.length == MAX_LETTER_LENGTH &&
                verticalTableValue[LETTER_INDEX] >= A_CHAR_VALUE &&
                verticalTableValue[LETTER_INDEX] <= Z_CHAR_VALUE;
    }

    private int getWidthIndexNumericValue(String move) {
        if (isLetterBiggerThanI(move)) return getWidthIndexForLetterBiggerThanI(move);
        else return getWidthIndexForLetterSmallerThanI(move);
    }

    private char getLetter(String move) {
        return move.replaceAll("\\d","").charAt(LETTER_INDEX);
    }

    private boolean isLetterBiggerThanI(String move) {
        return move.replaceAll("\\d","").charAt(LETTER_INDEX)  > 'I';
    }

    private int getWidthIndexForLetterBiggerThanI(String move) {
        return getLetter(move) - CALCULATE_WIDTH_INDEX_VALUE - 1;
    }

    private int getWidthIndexForLetterSmallerThanI(String move) {
        return move.replaceAll("\\d","").charAt(LETTER_INDEX) - CALCULATE_WIDTH_INDEX_VALUE;
    }

    private int getHeightCoordinateToStringForm(int heightCoordinate) {
        return height-heightCoordinate;
    }
}
