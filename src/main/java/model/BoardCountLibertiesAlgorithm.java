package model;

import java.util.ArrayList;
import java.util.List;

public class BoardCountLibertiesAlgorithm extends BoardGroupingAlgorithm {
    private final static int MINIMAL_HEIGHT_WIDTH_VALUE = 0;
    private final static char EMPTY_VALUE = '.';
    private List<WhiteCharsGroup> whiteGroupsWithCountedLiberties;
    private List<BlackCharsGroup> blackGroupsWithCountedLiberties;

    private List<WhiteCharsGroup> whiteCharsGroupWithoutLiberties;
    private List<BlackCharsGroup> blackCharsGroupWithoutLiberties;

    private char[][] board;

    public BoardCountLibertiesAlgorithm(int height, int width, List<String> listOfWhiteCharsCoordinates,
                                        List<String> listOfBlackCharsCoordinates, char[][] board) {
        super(height, width, listOfWhiteCharsCoordinates, listOfBlackCharsCoordinates);
        this.board = board;
        initializeLists();
        calculateLibertiesForAllWhiteGroups(getWhiteGroups());
        calculateLibertiesForAllBlackGroups(getBlackGroups());
        addGroupsWithoutLiberties();
    }

    public List<WhiteCharsGroup> getWhiteGroupsWithCountedLiberties() {
        return whiteGroupsWithCountedLiberties;
    }

    public List<BlackCharsGroup> getBlackGroupsWithCountedLiberties() {
        return blackGroupsWithCountedLiberties;
    }

    public List<WhiteCharsGroup> getWhiteCharsGroupWithoutLiberties() {
        return whiteCharsGroupWithoutLiberties;
    }

    public List<BlackCharsGroup> getBlackCharsGroupWithoutLiberties() {
        return blackCharsGroupWithoutLiberties;
    }

    private void addGroupsWithoutLiberties() {
        addWhiteGroupsWithoutLiberties();
        addBlackGroupsWithoutLiberties();
    }

    private void addWhiteGroupsWithoutLiberties() {
        for (int i = 0; i < whiteGroupsWithCountedLiberties.size(); i++) {
            if (whiteGroupsWithCountedLiberties.get(i).getLiberties()==0)
                whiteCharsGroupWithoutLiberties.add(whiteGroupsWithCountedLiberties.get(i));
        }
    }

    private void addBlackGroupsWithoutLiberties() {
        for (int i = 0; i < blackGroupsWithCountedLiberties.size(); i++) {
            if (blackGroupsWithCountedLiberties.get(i).getLiberties()==0)
                blackCharsGroupWithoutLiberties.add(blackGroupsWithCountedLiberties.get(i));
        }
    }

    private void initializeLists() {
        whiteGroupsWithCountedLiberties = new ArrayList<>();
        whiteCharsGroupWithoutLiberties = new ArrayList<>();
        blackGroupsWithCountedLiberties = new ArrayList<>();
        blackCharsGroupWithoutLiberties = new ArrayList<>();
    }

    private void calculateLibertiesForAllWhiteGroups(List<WhiteCharsGroup> whiteGroups) {
        for (int i = 0; i < whiteGroups.size(); i++) {
            whiteGroups.get(i).setLiberties(calculateLibertiesForWhiteGroup(whiteGroups.get(i)));
            whiteGroupsWithCountedLiberties.add(whiteGroups.get(i));
        }
    }

    private void calculateLibertiesForAllBlackGroups(List<BlackCharsGroup> blackGroups) {
        for (int i = 0; i < blackGroups.size(); i++) {
            blackGroups.get(i).setLiberties(calculateLibertiesForBlackGroup(blackGroups.get(i)));
            blackGroupsWithCountedLiberties.add(blackGroups.get(i));
        }
    }

    private int calculateLibertiesForWhiteGroup(WhiteCharsGroup whiteCharsGroup) {
        int liberties = 0;
        for (int i = 0; i < whiteCharsGroup.getMoves().size(); i++) {
            liberties+= calculateLiberties(whiteCharsGroup.getMoves().get(i));
        }
        return liberties;
    }

    private int calculateLibertiesForBlackGroup(BlackCharsGroup blackCharsGroup) {
        int liberties = 0;
        for (int i = 0; i < blackCharsGroup.getMoves().size(); i++) {
            liberties+= calculateLiberties(blackCharsGroup.getMoves().get(i));
        }
        return liberties;
    }


    private int calculateLiberties(String move) {
        int liberties = 0;
        int heightIndex = getHeightMoveIndex(move);
        int widthIndex = getIndexInTable(getWidthMoveIndex(move));
        if (isCharHaveLeftLiberty(heightIndex,widthIndex)) liberties +=1;
        if (isCharHaveRightLiberty(heightIndex,widthIndex)) liberties +=1;
        if (isCharHaveUpperLiberty(heightIndex,widthIndex)) liberties +=1;
        if (isCharHaveDownLiberty(heightIndex,widthIndex)) liberties +=1;
        return liberties;
    }

    private boolean isCharHaveLeftLiberty(int heightIndex, int widthIndex) {
        if (widthIndex > MINIMAL_HEIGHT_WIDTH_VALUE) return board[heightIndex][widthIndex-1] == EMPTY_VALUE;
        else return false;
    }

    private boolean isCharHaveRightLiberty(int heightIndex, int widthIndex) {
        if (widthIndex < getWidthMaxIndexInTable()) return board[heightIndex][widthIndex+1] == EMPTY_VALUE;
        else return false;
    }

    private boolean isCharHaveUpperLiberty(int heightIndex, int widthIndex) {
        if (heightIndex > MINIMAL_HEIGHT_WIDTH_VALUE) return board[heightIndex-1][widthIndex] == EMPTY_VALUE;
        else return false;
    }

    private boolean isCharHaveDownLiberty(int heightIndex, int widthIndex) {
        if (heightIndex < getHeightMaxIndexInTable()) return board[heightIndex+1][widthIndex] == EMPTY_VALUE;
        else return false;
    }

}
