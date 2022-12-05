package model;

import Exceptions.IllegalMoveException;
import Exceptions.IllegalRollbackException;
import Exceptions.SelfCapturedException;

import java.util.*;

public class Go {
    private final static int A_CHAR_VALUE = 65;
    private final static int Z_CHAR_VALUE = 90;
    private final static int MAX_LETTER_LENGTH = 1;
    private final static int MAX_HEIGHT_WIDTH_VALUE = 32;
    private final static int LETTER_INDEX = 0;
    private final static int MINIMUM_INDEX = 0;
    private final static int CALCULATE_WIDTH_INDEX_VALUE = 64;
    private final static int MINIMAL_HEIGHT_WIDTH_VALUE = 0;
    private final static int ROLLBACK_TO_TURN_PREVIOUS_ILLEGAL_SELF_CAPTURING = 1;
    private final char WHITE_CHAR = 'o';
    private final char BLACK_CHAR = 'x';
    private final char EMPTY_VALUE = '.';
    private char[][] board;
    private List<Move> moves;
    private List<String> listOfWhiteCharsCoordinates;
    private List<String> listOfBlackCharsCoordinates;
    private int height;
    private int width;
    private boolean isFirstMoveBeenMade = false;
    private boolean isHandicapMade = false;
    private Handicap handicap;
    private MoveTurn moveTurn;


    public Go(int height, int width) {
        createBoardByHeightWidth(height, width);
        setBoardHeightWidth(height, width);
        setTurnToBlacks();
        initializeMovesLog();
        initializeListsOfCharsCoordinates();
    }

    public Go(int size) {
        createBoardByHeightWidth(size, size);
        setBoardHeightWidth(size, size);
        setTurnToBlacks();
        initializeMovesLog();
        initializeListsOfCharsCoordinates();
    }

    public char[][] getBoard() {
        return board;
    }

    public String getBoardToString() {
        return new BoardViewGenerator(board).getBoardView();
    }

    public void move(String... moves) {
        setFirstMoveWasMade();
        doAllMoves(moves);

    }


    //Only 9x9,13x13,19x19 boards can handicap
    public void handicapStones(int stones) {
        if (isHandicapPossible()) handicap(stones);
        else throw new IllegalArgumentException();

    }

    public void passTurn() {
        setFirstMoveWasMade();
        addPassTurnInformation();
        setTurn();
    }

    public void reset() {
        resetFirstMoveWasMade();
        resetHandicapMoveWasMade();
        putResetInformationToTableMoves();
        createNewBoard();
        setTurnToBlacks();
        initializeListsOfCharsCoordinates();
        initializeMovesLog();
    }

    public String getTurn() {
        if (moveTurn == MoveTurn.WHITE) return "white";
        else return "black";
    }

    public String getPosition(String position) {
        return String.valueOf(board[getHeightMoveIndex(position)][getIndexInTable(getWidthMoveIndex(position))]);
    }

    public void rollBack(int turns) {
        if (isRollbackTurnCorrect(turns)) {
            rollbackByTurns(turns);
            addCharsLocationToLists();
        } else throw new IllegalRollbackException();
    }

    public List<Move> getRollbackMoves(int turns) {
        List<Move> movesToBack = new ArrayList<>();
        for (int i = 0; i < turns; i++) {
            movesToBack.add(moves.get(moves.size() - i - 1));
        }
        return movesToBack;
    }

    public List<String> getListOfWhiteCharsCoordinates() {
        return listOfWhiteCharsCoordinates;
    }

    public List<String> getListOfBlackCharsCoordinates() {
        return listOfBlackCharsCoordinates;
    }

    public HashMap<String, Integer> getSize() {
        HashMap<String, Integer> sizeMap = new HashMap<>();
        sizeMap.put("height", height);
        sizeMap.put("width", width);
        return sizeMap;
    }

    public void soutResults() {
        int blackChars = 0;
        int whiteChars = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]==BLACK_CHAR) blackChars++;
                else if (board[i][j]==WHITE_CHAR) whiteChars++;
            }
        }
        printResult(blackChars,whiteChars);

    }

    private void printResult(int blackChars, int whiteChars) {
        if (blackChars>whiteChars) System.out.println("WYGRAŁY CZARNE! " + blackChars + ":" + whiteChars);
        else if (blackChars<whiteChars) System.out.println("WYGRAŁY BIAŁE! " + blackChars + ":" + whiteChars);
        else System.out.println("REMIS! " + blackChars + ":" + whiteChars);
    }


    private boolean isHandicapPossible() {
        return !isHandicapMade && !isFirstMoveBeenMade;
    }

    private void createBoardByHeightWidth(int height, int width) {
        if (isCorrectHeightWidth(height, width)) board = createBoard(height, width);
    }

    private void setBoardHeightWidth(int height, int width) {
        this.height = height;
        this.width = width;
    }

    private void initializeMovesLog() {
        moves = new ArrayList<>();
    }

    private void handicap(int stones) {
        createNewHandicap(stones);
        setHandicapWasMade();
        addCharsLocationToLists();
        addHandicapInformationAndSetTurnToWhites();
    }

    private void addHandicapInformationAndSetTurnToWhites() {
        moves.add(new Move("Handicap", moveTurn, getBoardToString()));
        setTurnToWhites();
    }

    private void doAllMoves(String... moves) {
        for (int i = 0; i < moves.length; i++) {
            moveByGivenParameters(moves[i]);
            addCharsLocationToLists();
            countLibertiesAndDeleteGroupsWithoutLiberties();
            resetIllegalKoMove();
        }


}

    private void addPassTurnInformation() {
        moves.add(new Move("PASS",moveTurn,getBoardToString()));
    }

    private void setTurn() {
        if (moveTurn==MoveTurn.WHITE) setTurnToBlacks();
        else setTurnToWhites();
    }

    private void createNewBoard() {
        board = new Go(height,width).getBoard();
    }

    private void setTurnToBlacks() {
        moveTurn = MoveTurn.BLACK;
    }

    private void setTurnToWhites() {
        moveTurn = MoveTurn.WHITE;
    }

    private void initializeListsOfCharsCoordinates() {
        listOfWhiteCharsCoordinates = new ArrayList<>();
        listOfBlackCharsCoordinates  = new ArrayList<>();
    }

    private void createNewHandicap(int stones) {
        handicap = new Handicap(stones,board);
    }

    private void setFirstMoveWasMade() {
        isFirstMoveBeenMade = true;
    }

    private void resetFirstMoveWasMade() {
        isFirstMoveBeenMade = false;
    }

    private void setHandicapWasMade() {
        isHandicapMade = true;
    }

    private void resetHandicapMoveWasMade() {
        isHandicapMade = false;
    }

    private void moveByGivenParameters(String move) throws IllegalMoveException {
        if (isMoveCorrect(getHeightMoveIndex(move),getWidthMoveIndex(move)))  {
            this.moves.add(new Move(move,moveTurn,getBoardToString()));
            moveByMoveTurn(getHeightMoveIndex(move),getWidthMoveIndex(move));
        }
        else throw new IllegalMoveException();
    }

    private int getIndexInTable(int moveIndex) {
        return moveIndex-1;
    }

    private boolean isCellTaken(int heightMoveIndex, int widthMoveIndex) {
        return board[heightMoveIndex][getIndexInTable(widthMoveIndex)] == 'x' || board[heightMoveIndex][getIndexInTable(widthMoveIndex)] == 'o';
    }


    private void moveByMoveTurn(int heightMoveIndex, int widthMoveIndex) {
        if (moveTurn==MoveTurn.WHITE) moveTurnByWhite(heightMoveIndex,widthMoveIndex);
        else moveTurnByBlack(heightMoveIndex,widthMoveIndex);
    }

    private void moveTurnByBlack(int heightMoveIndex, int widthMoveIndex) {
        moveTurn = MoveTurn.WHITE;
        board[heightMoveIndex][getIndexInTable(widthMoveIndex)] = BLACK_CHAR;
    }


    private void moveTurnByWhite(int heightMoveIndex, int widthMoveIndex) {
        moveTurn = MoveTurn.BLACK;
        board[heightMoveIndex][getIndexInTable(widthMoveIndex)] = WHITE_CHAR;
    }

    private boolean isCorrectHeightWidth(int height, int width) {
        if (height>MINIMAL_HEIGHT_WIDTH_VALUE && width>MINIMAL_HEIGHT_WIDTH_VALUE &&
                height < MAX_HEIGHT_WIDTH_VALUE && width < MAX_HEIGHT_WIDTH_VALUE) return true;
        else throw new IllegalArgumentException();
    }

    private char[][] createBoard(int height,int width) {
        char[][] board = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = '.';
      }
    }
       return board;
    }

    public int getHeightMoveIndex(String move) {
        try {
           return height-Integer.parseInt(move.replaceAll("\\D",""));
        } catch (NumberFormatException e) {
            throw new IllegalMoveException();
        }
    }

    private int getWidthMoveIndex(String move) {
        if (isMovePropertyValue(move)) return getWidthIndexNumericValue(move);
        else {
            throw new IllegalMoveException();
        }
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

    private boolean isMoveCorrect(int heightIndex, int widthIndex) {
        return heightIndex >= MINIMUM_INDEX && heightIndex < height && widthIndex >= MINIMUM_INDEX && widthIndex <= width
                && !isCellTaken(heightIndex,widthIndex);
    }

    private void putResetInformationToTableMoves() {
        moves.add(new Move("RESET",moveTurn,getBoardToString()));

    }

    private void rollbackByTurns(int turns) {
        Move comebackToThisMove = moves.get(moves.size()-turns);
        board = comebackToThisMove.parseActualTableStringToBoardTable();
        moveTurn = comebackToThisMove.getMoveTurn();
        clearMovesTable(turns);
    }

    private void clearMovesTable(int turns) {
        List<Move> movesToDelete = getRollbackMoves(turns);
        for (int i = 0; i < movesToDelete.size(); i++) {
            moves.remove(movesToDelete.get(i));
        };
    }

    private boolean isRollbackTurnCorrect(int turns) {
        return moves.size() >= turns && turns > 0;
    }

    private void addCharsLocationToLists() {
        initializeListsOfCharsCoordinates();
        addCharactersToTheListFromTheLeftmost();
    }

    private void addCharactersToTheListFromTheLeftmost(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isWhiteCharValueOfBoardCell(i,j)) addToListOfWhiteCharsCoordinates(i,j);
                else if (isBlackCharValueOfBoardCell(i,j)) addToListOfBlackCharsCoordinates(i,j);
            }
        }
    }

    private boolean isWhiteCharValueOfBoardCell(int i, int j) {
        return board[i][j] == WHITE_CHAR;
    }

    private boolean isBlackCharValueOfBoardCell(int i, int j) {
        return board[i][j] == BLACK_CHAR;
    }

    private void addToListOfWhiteCharsCoordinates(int i, int j) {
        listOfWhiteCharsCoordinates.add(String.valueOf(getVerticalCoordinate(i))+ getHorizontalCoordinate(j));
    }

    private void addToListOfBlackCharsCoordinates(int i, int j) {
        listOfBlackCharsCoordinates.add(String.valueOf(getVerticalCoordinate(i))+ getHorizontalCoordinate(j));
    }

    private int getVerticalCoordinate(int i) {
        return height-i;
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

    private void countLibertiesAndDeleteGroupsWithoutLiberties() {
        BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm = new BoardCountLibertiesAlgorithm(height,width,listOfWhiteCharsCoordinates,listOfBlackCharsCoordinates,board);
        if (isAnyBlackGroupWithNoLiberties(boardCountLibertiesAlgorithm) && isAnyWhiteGroupWithNoLiberties(boardCountLibertiesAlgorithm)) capturedCharsWhenBlackAndWhitesLibertiesAreZero(boardCountLibertiesAlgorithm);
        else if (isAnyBlackGroupWithNoLiberties(boardCountLibertiesAlgorithm)) capturedBlackChars(boardCountLibertiesAlgorithm.getBlackCharsGroupWithoutLiberties());
        else if (isAnyWhiteGroupWithNoLiberties(boardCountLibertiesAlgorithm)) capturedWhiteChars(boardCountLibertiesAlgorithm.getWhiteCharsGroupWithoutLiberties());

    }

    private void capturedCharsWhenBlackAndWhitesLibertiesAreZero(BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm) {
        if (moveTurn==MoveTurn.WHITE) capturedWhiteCharsInKo(boardCountLibertiesAlgorithm.getWhiteCharsGroupWithoutLiberties());
        else capturedBlackCharsInKo(boardCountLibertiesAlgorithm.getBlackCharsGroupWithoutLiberties());
    }

    private boolean isAnyWhiteGroupWithNoLiberties(BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm) {
        return boardCountLibertiesAlgorithm.getWhiteCharsGroupWithoutLiberties().size() > 0;
    }

    private boolean isAnyBlackGroupWithNoLiberties(BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm) {
        return boardCountLibertiesAlgorithm.getBlackCharsGroupWithoutLiberties().size() > 0;
    }


    private void capturedBlackChars( List<BlackCharsGroup> blackGroupsWithNoLiberties) {
        if (isBlackNoSelfCaptured())
            for (int i = 0; i < blackGroupsWithNoLiberties.size(); i++) {
                deleteBlackCharsFromBoardAndListOfBlackCharsCoordinates(blackGroupsWithNoLiberties.get(i));
            }
        else returnTurnAfterSelfCaptured();

    }

    private void capturedWhiteCharsInKo(List<WhiteCharsGroup> whiteCharsWithoutLiberties) {
        for (int i = 0; i < whiteCharsWithoutLiberties.size() ; i++) {
            deleteWhiteCharsFromBoardAndListOfWhiteCharsCoordinates(whiteCharsWithoutLiberties.get(i));
        }
    }

    private void capturedBlackCharsInKo(List<BlackCharsGroup> blackCharsWithoutLiberties) {
        for (int i = 0; i < blackCharsWithoutLiberties.size() ; i++) {
            deleteBlackCharsFromBoardAndListOfBlackCharsCoordinates(blackCharsWithoutLiberties.get(i));
        }
    }



    private void capturedWhiteChars(List<WhiteCharsGroup> whiteCharsWithoutLiberties) {
        if (isWhiteNoSelfCaptured()) {
            for (int i = 0; i < whiteCharsWithoutLiberties.size() ; i++) {
                deleteWhiteCharsFromBoardAndListOfWhiteCharsCoordinates(whiteCharsWithoutLiberties.get(i));
            }
        }
        else returnTurnAfterSelfCaptured();
    }

    private boolean isWhiteNoSelfCaptured() {
        return moveTurn !=MoveTurn.BLACK;
    }

    private boolean isBlackNoSelfCaptured() {
        return moveTurn != MoveTurn.WHITE;
    }

    private void returnTurnAfterSelfCaptured() {
        rollBack(ROLLBACK_TO_TURN_PREVIOUS_ILLEGAL_SELF_CAPTURING);
        throw  new SelfCapturedException();
    }

    private void deleteBlackCharsFromBoardAndListOfBlackCharsCoordinates(BlackCharsGroup blackCharsGroup) {
        for (int i = 0; i < blackCharsGroup.getMoves().size() ; i++) {
            deleteBlackChars(blackCharsGroup.getMoves().get(i));
        }
    }

    private void deleteWhiteCharsFromBoardAndListOfWhiteCharsCoordinates(WhiteCharsGroup whiteCharsGroup) {
        for (int i = 0; i < whiteCharsGroup.getMoves().size() ; i++) {
            deleteWhiteChars(whiteCharsGroup.getMoves().get(i));
        }
    }

    private void deleteWhiteChars(String move) {
        setEmptyValueInThisCoordinateFromWhiteCharsGroup(move);
        removeCoordinateFromWhiteCharsList(move);
    }

    private void deleteBlackChars(String move) {
        setEmptyValueInThisCoordinateFromBlackCharsGroup(move);
        removeCoordinateFromBlackCharsList(move);
    }

    private void setEmptyValueInThisCoordinateFromBlackCharsGroup(String move) {
        board[getHeightMoveIndex(move)][getIndexInTable(getWidthMoveIndex(move))] = EMPTY_VALUE;
    }

    private void setEmptyValueInThisCoordinateFromWhiteCharsGroup(String move) {
        board[getHeightMoveIndex(move)][getIndexInTable(getWidthMoveIndex(move))] = EMPTY_VALUE;
    }

    private void removeCoordinateFromWhiteCharsList(String move) {
        listOfWhiteCharsCoordinates.remove(move);
    }

    private void removeCoordinateFromBlackCharsList(String move) {
        listOfBlackCharsCoordinates.remove(move);
    }

    private void resetIllegalKoMove() {
        if (moves.size()>3) {
            if (isBoardInTheLastMoveOfThisPlayerSame())  {
                rollBack(1);
                throw new IllegalArgumentException();
            }
        }
    }
    private String getPreviousMoveByThisPlayer() {
        return moves.get(moves.size()-2).getBoardBeforeThisMove();
    }

    private boolean isBoardInTheLastMoveOfThisPlayerSame() {
        return getPreviousMoveByThisPlayer().equals(getBoardToString());
    }
}
