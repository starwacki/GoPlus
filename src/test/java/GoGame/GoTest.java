package GoGame;

import model.Go;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class GoTest {

    @Test
    public void shouldReturn5x5CharTable() {
        Go go  =  new Go(5);
        char[][] gameBoard = go.getBoard();
        char[][] expectedBoard = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}};
        assertEquals(Arrays.toString(expectedBoard[0]),Arrays.toString(gameBoard[0]));
        assertEquals(Arrays.toString(expectedBoard[1]),Arrays.toString(gameBoard[1]));
        assertEquals(Arrays.toString(expectedBoard[2]),Arrays.toString(gameBoard[2]));
        assertEquals(Arrays.toString(expectedBoard[3]),Arrays.toString(gameBoard[3]));
        assertEquals(Arrays.toString(expectedBoard[4]),Arrays.toString(gameBoard[4]));
    }

    @Test
    public void shouldReturn6x5CharTable() {
        Go go  =  new Go(6,5);
        char[][] gameBoard = go.getBoard();
        char[][] expectedBoard = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}};
        assertEquals(Arrays.toString(expectedBoard[0]),Arrays.toString(gameBoard[0]));
        assertEquals(Arrays.toString(expectedBoard[1]),Arrays.toString(gameBoard[1]));
        assertEquals(Arrays.toString(expectedBoard[2]),Arrays.toString(gameBoard[2]));
        assertEquals(Arrays.toString(expectedBoard[3]),Arrays.toString(gameBoard[3]));
        assertEquals(Arrays.toString(expectedBoard[4]),Arrays.toString(gameBoard[4]));
        assertEquals(Arrays.toString(expectedBoard[5]),Arrays.toString(gameBoard[5]));
    }

    @Test
    public void shouldReturn5x6CharTable() {
        Go go  =  new Go(5,6);
        char[][] gameBoard = go.getBoard();
        char[][] expectedBoard = {
                {'.','.','.','.','.','.'},
                {'.','.','.','.','.','.'},
                {'.','.','.','.','.','.'},
                {'.','.','.','.','.','.'},
                {'.','.','.','.','.','.'}};
        assertEquals(Arrays.toString(expectedBoard[0]),Arrays.toString(gameBoard[0]));
        assertEquals(Arrays.toString(expectedBoard[1]),Arrays.toString(gameBoard[1]));
        assertEquals(Arrays.toString(expectedBoard[2]),Arrays.toString(gameBoard[2]));
        assertEquals(Arrays.toString(expectedBoard[3]),Arrays.toString(gameBoard[3]));
        assertEquals(Arrays.toString(expectedBoard[4]),Arrays.toString(gameBoard[4]));
    }

    @Test
    public void ZeroSizeShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(0);
        });
    }

    @Test
    public void ZeroWidthShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(10,0);
        });
    }

    @Test
    public void zeroHeightShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(0,10);
        });
    }

    @Test
    public void negativeSizeShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(5,-10);
        });
    }

    @Test
    public void shouldReturn5x5CorrectBoardString() {
        Go go = new Go(5);
        String board5x5String = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 . . . . .
                """;
        assertEquals(board5x5String,go.getBoardToString());
    }

    @Test
    public void shouldReturn6x5CorrectBoardString() {
        Go go = new Go(6,5);
        String board6x5String = """
                  A B C D E
                6 . . . . .
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 . . . . .
                """;
        assertEquals(board6x5String,go.getBoardToString());
    }

    @Test
    public void shouldReturn5x6CorrectBoardString() {
        Go go = new Go(5,6);
        String board5x6String = """
                  A B C D E F
                5 . . . . . .
                4 . . . . . .
                3 . . . . . .
                2 . . . . . .
                1 . . . . . .
                """;
        assertEquals(board5x6String,go.getBoardToString());
    }

    @Test
    public void shouldReturn10x10CorrectBoardString() {
        Go go = new Go(10,10);
        String board10x10String = """
                   A B C D E F G H J K
                10 . . . . . . . . . .
                9  . . . . . . . . . .
                8  . . . . . . . . . .
                7  . . . . . . . . . .
                6  . . . . . . . . . .
                5  . . . . . . . . . .
                4  . . . . . . . . . .
                3  . . . . . . . . . .
                2  . . . . . . . . . .
                1  . . . . . . . . . .
                """;
        assertEquals(board10x10String,go.getBoardToString());
    }

    @Test
    public void shouldReturn10x13CorrectBoardString() {
        Go go = new Go(10,13);
        String board10x13String = """
                   A B C D E F G H J K L M N
                10 . . . . . . . . . . . . .
                9  . . . . . . . . . . . . .
                8  . . . . . . . . . . . . .
                7  . . . . . . . . . . . . .
                6  . . . . . . . . . . . . .
                5  . . . . . . . . . . . . .
                4  . . . . . . . . . . . . .
                3  . . . . . . . . . . . . .
                2  . . . . . . . . . . . . .
                1  . . . . . . . . . . . . .
                """;
        assertEquals(board10x13String,go.getBoardToString());
    }

    @Test
    public void shouldReturn13x10CorrectBoardString() {
        Go go = new Go(13,10);
        String board13x10String = """
                   A B C D E F G H J K
                13 . . . . . . . . . .
                12 . . . . . . . . . .
                11 . . . . . . . . . .   
                10 . . . . . . . . . .
                9  . . . . . . . . . .
                8  . . . . . . . . . .
                7  . . . . . . . . . .
                6  . . . . . . . . . .
                5  . . . . . . . . . .
                4  . . . . . . . . . .
                3  . . . . . . . . . .
                2  . . . . . . . . . .
                1  . . . . . . . . . .
                """;
        assertEquals(board13x10String,go.getBoardToString());
    }

    @Test
    public void shouldReturn9x10CorrectBoardString() {
        Go go = new Go(9,10);
        String board9x10String = """
                  A B C D E F G H J K
                9 . . . . . . . . . . 
                8 . . . . . . . . . . 
                7 . . . . . . . . . . 
                6 . . . . . . . . . . 
                5 . . . . . . . . . . 
                4 . . . . . . . . . . 
                3 . . . . . . . . . . 
                2 . . . . . . . . . . 
                1 . . . . . . . . . .
                """;
        assertEquals(board9x10String,go.getBoardToString());
    }

    @Test
    public void shouldReturn10x9CorrectBoardString() {
        Go go = new Go(10,9);
        String board10x9String = """
                   A B C D E F G H J
                10 . . . . . . . . . 
                9  . . . . . . . . . 
                8  . . . . . . . . . 
                7  . . . . . . . . . 
                6  . . . . . . . . .  
                5  . . . . . . . . .  
                4  . . . . . . . . .  
                3  . . . . . . . . . 
                2  . . . . . . . . .
                1  . . . . . . . . .
                """;
        assertEquals(board10x9String,go.getBoardToString());
    }
    @Test
    public void biggerThan32TableSizeShouldReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,()-> {
            Go go = new Go(33);
        });
    }

    @Test
    public void biggerThan32TableWidthShouldReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,()-> {
            Go go = new Go(15,33);
        });
    }

    @Test
    public void emptyStringShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(5);
            go.move("");
        });
    }

    @Test
    public void singleLetterShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(5);
            go.move("A");
        });
    }

    @Test
    public void singleNumberThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(5);
            go.move("2");
        });
    }

    @Test
    public void moreThanOneLetterStringShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(5);
            go.move("2AA");
        });
    }

    @Test
    public void moveTo1AByBlackShouldReturnBoardWithXCharIn1A() {
        Go go = new Go(5);
        go.move("1A");
        String board5x5String = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 x . . . .
                """;
        assertEquals(board5x5String,go.getBoardToString());

    }

    @Test
    public void moveTo1AByBlackAndTo5EByWhiteShouldReturnBoardWithXCharIn1AAndOCharIn5E() {
        Go go = new Go(5);
        go.move("1A");
        go.move("5E");
        String board5x5String = """
                  A B C D E
                5 . . . . o
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 x . . . .
                """;
        assertEquals(board5x5String,go.getBoardToString());
    }

    @Test
    public void moveByMultipleParametersTo1AByBlackAndTo5EByWhiteShouldReturnBoardWithXCharIn1AAndOCharIn5E() {
        Go go = new Go(5);
        go.move("1A","5E");
        String board5x5String = """
                  A B C D E
                5 . . . . o
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 x . . . .
                """;
        assertEquals(board5x5String,go.getBoardToString());
    }

    @Test
    public void moveToTakenCellShouldReturnIllegalArgumentException() {
        Go go = new Go(5);
        assertThrows(IllegalArgumentException.class,() -> {
            go.move("5A");
            go.move("5A");
        });
    }

    @Test
    public void movesShouldReturnExpectedBoard() {
        Go go = new Go(5);
        go.move("1A");
        go.move("5E");
        go.move("3D");
        go.move("1B");
        String expectedBoard5x5String = """
                  A B C D E
                5 . . . . o
                4 . . . . .
                3 . . . x .
                2 . . . . .
                1 x o . . .
                """;
        assertEquals(expectedBoard5x5String, go.getBoardToString());
    }

    @Test
     public void movesToFilledCellShouldReturnIllegalArgumentException() {
        Go go = new Go(5,5);
        assertThrows(IllegalArgumentException.class,() -> {
           go.move("1A","1A");
        });
    }

    @Test
    public void wrongBoardSizeShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
                Go go = new Go(5);
                go.handicapStones(1);
        });
    }

    @Test
    public void tooManyHandicapStonesToFirstGroupBoardShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(9);
            go.handicapStones(6);
        });
    }

    @Test
    public void negativeStonesNumberShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(9);
            go.handicapStones(-1);
        });
    }

    @Test
    public void tooManyHandicapStonesToSecondGroupBoardShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(13);
            go.handicapStones(10);
        });
    }

    @Test
    public void tooManyHandicapStonesToThirdGroupBoardShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,() -> {
            Go go = new Go(19);
            go.handicapStones(10);
        });
    }

    @Test
    public void shouldReturnBoardWith9StonesByThirdTableGroupHandicap() {
        Go go = new Go(19,19);
        go.handicapStones(9);
        String expectedBoard = """
                 A B C D E F G H J K L M N O P Q R S T
              19 . . . . . . . . . . . . . . . . . . .
              18 . . . . . . . . . . . . . . . . . . .
              17 . . . . . . . . . . . . . . . . . . .
              16 . . . x . . . . . x . . . . . x . . .
              15 . . . . . . . . . . . . . . . . . . .
              14 . . . . . . . . . . . . . . . . . . .
              13 . . . . . . . . . . . . . . . . . . .
              12 . . . . . . . . . . . . . . . . . . .
              11 . . . . . . . . . . . . . . . . . . .
              10 . . . x . . . . . x . . . . . x . . .
              9  . . . . . . . . . . . . . . . . . . .
              8  . . . . . . . . . . . . . . . . . . .
              7  . . . . . . . . . . . . . . . . . . .
              6  . . . . . . . . . . . . . . . . . . .
              5  . . . . . . . . . . . . . . . . . . .
              4  . . . x . . . . . x . . . . . x . . .
              3  . . . . . . . . . . . . . . . . . . .
              2  . . . . . . . . . . . . . . . . . . .
              1  . . . . . . . . . . . . . . . . . . .
                """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

    @Test
    public void shouldReturnBoardWith8StonesByThirdTableGroupHandicap() {
        Go go = new Go(19,19);
        go.handicapStones(8);
        String expectedBoard = """
                 A B C D E F G H J K L M N O P Q R S T
              19 . . . . . . . . . . . . . . . . . . .
              18 . . . . . . . . . . . . . . . . . . .
              17 . . . . . . . . . . . . . . . . . . .
              16 . . . x . . . . . x . . . . . x . . .
              15 . . . . . . . . . . . . . . . . . . .
              14 . . . . . . . . . . . . . . . . . . .
              13 . . . . . . . . . . . . . . . . . . .
              12 . . . . . . . . . . . . . . . . . . .
              11 . . . . . . . . . . . . . . . . . . .
              10 . . . x . . . . . x . . . . . x . . .
              9  . . . . . . . . . . . . . . . . . . .
              8  . . . . . . . . . . . . . . . . . . .
              7  . . . . . . . . . . . . . . . . . . .
              6  . . . . . . . . . . . . . . . . . . .
              5  . . . . . . . . . . . . . . . . . . .
              4  . . . x . . . . . . . . . . . x . . .
              3  . . . . . . . . . . . . . . . . . . .
              2  . . . . . . . . . . . . . . . . . . .
              1  . . . . . . . . . . . . . . . . . . .
                """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

    @Test
    public void shouldReturnBoardWith5StonesByThirdTableGroupHandicap() {
        Go go = new Go(19,19);
        go.handicapStones(5);
        String expectedBoard = """
                 A B C D E F G H J K L M N O P Q R S T
              19 . . . . . . . . . . . . . . . . . . .
              18 . . . . . . . . . . . . . . . . . . .
              17 . . . . . . . . . . . . . . . . . . .
              16 . . . x . . . . . . . . . . . x . . .
              15 . . . . . . . . . . . . . . . . . . .
              14 . . . . . . . . . . . . . . . . . . .
              13 . . . . . . . . . . . . . . . . . . .
              12 . . . . . . . . . . . . . . . . . . .
              11 . . . . . . . . . . . . . . . . . . .
              10 . . . . . . . . . x . . . . . . . . .
              9  . . . . . . . . . . . . . . . . . . .
              8  . . . . . . . . . . . . . . . . . . .
              7  . . . . . . . . . . . . . . . . . . .
              6  . . . . . . . . . . . . . . . . . . .
              5  . . . . . . . . . . . . . . . . . . .
              4  . . . x . . . . . . . . . . . x . . .
              3  . . . . . . . . . . . . . . . . . . .
              2  . . . . . . . . . . . . . . . . . . .
              1  . . . . . . . . . . . . . . . . . . .
                """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

    @Test
    public void shouldReturnBoardWith1StonesByThirdTableGroupHandicap() {
        Go go = new Go(19,19);
        go.handicapStones(1);
        String expectedBoard = """
                 A B C D E F G H J K L M N O P Q R S T
              19 . . . . . . . . . . . . . . . . . . .
              18 . . . . . . . . . . . . . . . . . . .
              17 . . . . . . . . . . . . . . . . . . .
              16 . . . . . . . . . . . . . . . x . . .
              15 . . . . . . . . . . . . . . . . . . .
              14 . . . . . . . . . . . . . . . . . . .
              13 . . . . . . . . . . . . . . . . . . .
              12 . . . . . . . . . . . . . . . . . . .
              11 . . . . . . . . . . . . . . . . . . .
              10 . . . . . . . . . . . . . . . . . . .
              9  . . . . . . . . . . . . . . . . . . .
              8  . . . . . . . . . . . . . . . . . . .
              7  . . . . . . . . . . . . . . . . . . .
              6  . . . . . . . . . . . . . . . . . . .
              5  . . . . . . . . . . . . . . . . . . .
              4  . . . . . . . . . . . . . . . . . . .
              3  . . . . . . . . . . . . . . . . . . .
              2  . . . . . . . . . . . . . . . . . . .
              1  . . . . . . . . . . . . . . . . . . .
                """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

    @Test
    public void shouldReturnBoardWith9StonesBySecondTableGroupHandicap() {
        Go go = new Go(13,13);
        go.handicapStones(9);
        String expectedBoard = """
                 A B C D E F G H J K L M N
              13 . . . . . . . . . . . . .
              12 . . . . . . . . . . . . .
              11 . . . . . . . . . . . . .
              10 . . . x . . x . . x . . .
              9  . . . . . . . . . . . . .
              8  . . . . . . . . . . . . .
              7  . . . x . . x . . x . . .
              6  . . . . . . . . . . . . .
              5  . . . . . . . . . . . . .
              4  . . . x . . x . . x . . .
              3  . . . . . . . . . . . . .
              2  . . . . . . . . . . . . .
              1  . . . . . . . . . . . . .
              """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

    @Test
    public void shouldReturnBoardWith8StonesBySecondTableGroupHandicap() {
        Go go = new Go(13,13);
        go.handicapStones(8);
        String expectedBoard = """
                 A B C D E F G H J K L M N
              13 . . . . . . . . . . . . .
              12 . . . . . . . . . . . . .
              11 . . . . . . . . . . . . .
              10 . . . x . . x . . x . . .
              9  . . . . . . . . . . . . .
              8  . . . . . . . . . . . . .
              7  . . . x . . x . . x . . .
              6  . . . . . . . . . . . . .
              5  . . . . . . . . . . . . .
              4  . . . x . . . . . x . . .
              3  . . . . . . . . . . . . .
              2  . . . . . . . . . . . . .
              1  . . . . . . . . . . . . .
              """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

    @Test
    public void shouldReturnBoardWith5StonesBySecondTableGroupHandicap() {
        Go go = new Go(13,13);
        go.handicapStones(5);
        String expectedBoard = """
                 A B C D E F G H J K L M N
              13 . . . . . . . . . . . . .
              12 . . . . . . . . . . . . .
              11 . . . . . . . . . . . . .
              10 . . . x . . . . . x . . .
              9  . . . . . . . . . . . . .
              8  . . . . . . . . . . . . .
              7  . . . . . . x . . . . . .
              6  . . . . . . . . . . . . .
              5  . . . . . . . . . . . . .
              4  . . . x . . . . . x . . .
              3  . . . . . . . . . . . . .
              2  . . . . . . . . . . . . .
              1  . . . . . . . . . . . . .
              """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

    @Test
    public void shouldReturnBoardWith1StonesBySecondTableGroupHandicap() {
        Go go = new Go(13,13);
        go.handicapStones(1);
        String expectedBoard = """
                 A B C D E F G H J K L M N
              13 . . . . . . . . . . . . .
              12 . . . . . . . . . . . . .
              11 . . . . . . . . . . . . .
              10 . . . . . . . . . x . . .
              9  . . . . . . . . . . . . .
              8  . . . . . . . . . . . . .
              7  . . . . . . . . . . . . .
              6  . . . . . . . . . . . . .
              5  . . . . . . . . . . . . .
              4  . . . . . . . . . . . . .
              3  . . . . . . . . . . . . .
              2  . . . . . . . . . . . . .
              1  . . . . . . . . . . . . .
              """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

    @Test
    public void shouldReturnBoardWith5StonesByFirstTableGroupHandicap() {
        Go go = new Go(9,9);
        go.handicapStones(5);
        String expectedBoard = """
                A B C D E F G H J
              9 . . . . . . . . .
              8 . . . . . . . . .
              7 . . x . . . x . .
              6 . . . . . . . . .
              5 . . . . x . . . .
              4 . . . . . . . . .
              3 . . x . . . x . .
              2 . . . . . . . . .
              1 . . . . . . . . .
              """;
        assertEquals(expectedBoard,go.getBoardToString());
    }


        @Test
        public void shouldReturnBoardWith1StonesByFirstTableGroupHandicap () {
        Go go = new Go(9, 9);
        go.handicapStones(1);
            String expectedBoard = """
                A B C D E F G H J
              9 . . . . . . . . .
              8 . . . . . . . . .
              7 . . . . . . x . .
              6 . . . . . . . . .
              5 . . . . . . . . .
              4 . . . . . . . . .
              3 . . . . . . . . .
              2 . . . . . . . . .
              1 . . . . . . . . .
              """;
            assertEquals(expectedBoard, go.getBoardToString());
        }

        @Test
        public void shouldReturnBlackTurn() {
        Go go = new Go(5);
        String expectedTurn = "black";
        assertEquals(expectedTurn,go.getTurn());
        }

    @Test
    public void shouldReturnWhiteTurn() {
        Go go = new Go(5);
        go.move("5A");
        String expectedTurn = "white";
        assertEquals(expectedTurn,go.getTurn());
    }

    @Test
    public void shouldReturnWhiteAfterPassTurn() {
        Go go = new Go(5);
        go.passTurn();
        String expectedTurn = "white";
        assertEquals(expectedTurn,go.getTurn());
    }

    @Test
    public void shouldReturnBlackAfterTwoPassTurn() {
        Go go = new Go(5);
        go.passTurn();
        go.passTurn();
        String expectedTurn = "black";
        assertEquals(expectedTurn,go.getTurn());
    }

    @Test
    public void shouldReturnBlackAfterMoveAndPassTurn() {
        Go go = new Go(5);
        go.move("5A");
        go.passTurn();
        String expectedTurn = "black";
        assertEquals(expectedTurn,go.getTurn());
    }

    @Test
    public void shouldReturnCleanTable() {
        Go go = new Go(5);
        go.move("5A","5B","5C");
        go.reset();
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 . . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnCleanTableAfterPassTurn() {
        Go go = new Go(5);
        go.passTurn();
        go.reset();
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 . . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnBlackMoveAfterReset() {
        Go go = new Go(5);
        go.reset();
        String expectedTurn = "black";
        assertEquals(expectedTurn,go.getTurn());
    }

    @Test
    public void shouldReturnBlackMoveAfterResetAndMove() {
        Go go = new Go(5);
        go.move("2A");
        go.reset();
        String expectedTurn = "black";
        assertEquals(expectedTurn,go.getTurn());
    }

    @Test
    public void shouldReturnBlackMoveAfterResetAndPassTurn() {
        Go go = new Go(5);
        go.passTurn();
        go.reset();
        String expectedTurn = "black";
        assertEquals(expectedTurn,go.getTurn());
    }

    @Test
    public void shouldReturnEmptyTableValue() {
        Go go = new Go(5);
        go.move("5A");
        String expectedValue = ".";
        assertEquals(expectedValue,go.getPosition("1A"));
    }
    @Test
    public void shouldReturnBlackCharToStringTableValue() {
        Go go = new Go(5);
        go.move("5A");
        String expectedValue = "x";
        assertEquals(expectedValue,go.getPosition("5A"));
    }

    @Test
    public void shouldReturnWhiteCharToStringTableValue() {
        Go go = new Go(5);
        go.move("5A","4A");
        String expectedValue = "o";
        assertEquals(expectedValue,go.getPosition("4A"));
    }

    @Test
    public void shouldReturnEmptyTableAfterRollbackAfterFirstTurn() {
        Go go = new Go(5);
        go.move("5A");
        go.rollBack(1);
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 . . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnTableWithOneCharAtA5AfterRollback() {
        Go go = new Go(5);
        go.move("5A");
        go.move("5C");
        go.rollBack(1);
        String expectedTableToString = """
                  A B C D E
                5 x . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 . . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnTableWithOneCharAtA5After2Rollbacks() {
        Go go = new Go(5);
        go.move("5A");
        go.move("5C");
        go.move("4A");
        go.rollBack(2);
        String expectedTableToString = """
                  A B C D E
                5 x . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 . . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnEmptyTableAferPassTurnAndRollback() {
        Go go = new Go(5);
        go.passTurn();
        go.rollBack(1);
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 . . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }


    @Test
    public void shouldReturnEmptyTableAfterPass2TurnsAndRollback() {
        Go go = new Go(5);
        go.passTurn();
        go.passTurn();
        go.rollBack(1);
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 . . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnTableWithOneCharAfterPassTurnsAndRollback() {
        Go go = new Go(5);
        go.move("1A");
        go.passTurn();
        go.rollBack(1);
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 x . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnTableWithCharsAfterPassTurnsAndRollback() {
        Go go = new Go(5);
        go.move("1A");
        go.move("2A");
        go.passTurn();
        go.rollBack(2);
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 . . . . .
                1 x . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnTableWithCharsAfterOnlyPassingTurnsAndRollback() {
        Go go = new Go(5);
        go.move("1A");
        go.move("2A");
        go.passTurn();
        go.passTurn();
        go.rollBack(2);
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 o . . . .
                1 x . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }
    @Test
    public void illegalRollbackNumberShouldReturnIllegalArgumentException() {
        Go go = new Go(5);
        assertThrows(IllegalArgumentException.class,() -> {
           go.move("2A","3A");
           go.rollBack(3);
        });
    }

    @Test
    public void shouldReturnTableWithCharsAfterRollbackAndMove() {
        Go go = new Go(5);
        go.move("1A");
        go.move("2A");
        go.passTurn();
        go.rollBack(2);
        go.move("2A");
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 o . . . .
                1 x . . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnWhiteTurnAfterRollback() {
        Go go = new Go(5);
        go.move("1A");
        go.move("2A");
        go.passTurn();
        go.rollBack(2);
        String expectedTableToString = "white";
        assertEquals(expectedTableToString,go.getTurn());
    }

    @Test
    public void shouldReturnBlackTurnAfterRollback() {
        Go go = new Go(5);
        go.move("1A");
        go.move("2A");
        go.passTurn();
        go.rollBack(3);
        String expectedTableToString = "black";
        assertEquals(expectedTableToString,go.getTurn());
    }

    @Test
    public void shouldReturnWhiteTurnAfterRollbackAndMultiplePassingTurn() {
        Go go = new Go(5);
        go.move("1A");
        go.passTurn();
        go.passTurn();
        go.passTurn();
        go.rollBack(3);
        String expectedTableToString = "white";
        assertEquals(expectedTableToString,go.getTurn());
    }

    @Test
    public void shouldReturnHashMapWith5X5Size() {
        Go go = new Go(5);
        int expectedHeight = 5;
        int expectedWidth = 5;
        assertEquals(5,go.getSize().get("height"));
        assertEquals(5,go.getSize().get("width"));
    }

    @Test
    public void shouldReturnHashMapWith5X6Size() {
        Go go = new Go(5,6);
        int expectedHeight = 5;
        int expectedWidth = 6;
        assertEquals(5,go.getSize().get("height"));
        assertEquals(6,go.getSize().get("width"));
    }

    @Test
    public void shouldReturnHashMapWith6X5Size() {
        Go go = new Go(6,5);
        int expectedHeight = 6;
        int expectedWidth = 5;
        assertEquals(6,go.getSize().get("height"));
        assertEquals(5,go.getSize().get("width"));
    }

    @Test
    public void multiHandicapShouldReturnIllegalArgumentException() {
        Go go = new Go(13);
        assertThrows(IllegalArgumentException.class, () -> {
            go.handicapStones(5);
            go.handicapStones(4);
        });
    }

    @Test
    public void movesShouldReturnActualBlackAndWhiteCharsAtTable() {
        Go go = new Go(13);
        go.move("2A","1A","3A","4A");
        List<String> expectedBlackCharsCoordinates = List.of("3A","2A");
        List<String> expectedWhiteCharCoordinates = List.of("4A","1A");
        assertEquals(expectedWhiteCharCoordinates,go.getListOfWhiteCharsCoordinates());
        assertEquals(expectedBlackCharsCoordinates,go.getListOfBlackCharsCoordinates());
    }

    @Test
    public void shouldReturnEmptyListOfBlackAndWhiteCoordinates() {
        Go go = new Go(13);
        go.move();
        List<String> expectedBlackCharsCoordinates = List.of();
        List<String> expectedWhiteCharCoordinates = List.of();
        assertEquals(expectedWhiteCharCoordinates,go.getListOfWhiteCharsCoordinates());
        assertEquals(expectedBlackCharsCoordinates,go.getListOfBlackCharsCoordinates());
    }

    @Test
    public void shouldReturnListOfBlackCharsHandicapCoordinatesAndEmptyWhiteCharsCoordinates() {
        Go go = new Go(13);
        go.handicapStones(5);
        List<String> expectedBlackCharsCoordinates = List.of("10D", "10K", "7G", "4D", "4K");
        List<String> expectedWhiteCharCoordinates = List.of();
        assertEquals(expectedWhiteCharCoordinates,go.getListOfWhiteCharsCoordinates());
        assertEquals(expectedBlackCharsCoordinates,go.getListOfBlackCharsCoordinates());
    }

    @Test
    public void shouldReturnListOfBlackCharsHandicapCoordinatesAndWhiteCharsCoordinates() {
        Go go = new Go(13);
        go.handicapStones(5);
        go.move("1A");
        go.move("2A");
        List<String> expectedBlackCharsCoordinates = List.of("10D", "10K", "7G", "4D", "4K","2A");
        List<String> expectedWhiteCharCoordinates = List.of("1A");
        assertEquals(expectedWhiteCharCoordinates,go.getListOfWhiteCharsCoordinates());
        assertEquals(expectedBlackCharsCoordinates,go.getListOfBlackCharsCoordinates());
    }

    @Test
    public void shouldReturnListOfBlackCharsHandicapCoordinatesAndOneWhiteCharCoordinatesAfterRollback() {
        Go go = new Go(13);
        go.handicapStones(5);
        go.move("1A");
        go.move("2A");
        go.rollBack(1);
        List<String> expectedBlackCharsCoordinates = List.of("10D", "10K", "7G", "4D", "4K");
        List<String> expectedWhiteCharsCoordinates = List.of("1A");
        assertEquals(expectedBlackCharsCoordinates,go.getListOfBlackCharsCoordinates());
        assertEquals(expectedWhiteCharsCoordinates,go.getListOfWhiteCharsCoordinates());
    }

    @Test
    public void shouldReturnListOfBlackCharsHandicapCoordinatesAndEmptyWhiteCharsCoordinatesAfterMultipleRollback() {
        Go go = new Go(13);
        go.handicapStones(5);
        go.move("1A");
        go.move("2A");
        go.rollBack(1);
        go.rollBack(1);
        List<String> expectedBlackCharsCoordinates = List.of("10D", "10K", "7G", "4D", "4K");
        List<String> expectedWhiteCharsCoordinates = List.of();
        assertEquals(expectedBlackCharsCoordinates,go.getListOfBlackCharsCoordinates());
        assertEquals(expectedWhiteCharsCoordinates,go.getListOfWhiteCharsCoordinates());
    }

    @Test
    public void shouldReturnEmptyListsOfBlackAndWhiteCharsAfterReset() {
        Go go = new Go(13);
        go.move("1A");
        go.move("2A");
        go.move("3A");
        go.reset();
        List<String> expectedBlackCharsCoordinates = List.of();
        List<String> expectedWhiteCharCoordinates = List.of();
        assertEquals(expectedWhiteCharCoordinates,go.getListOfWhiteCharsCoordinates());
        assertEquals(expectedBlackCharsCoordinates,go.getListOfBlackCharsCoordinates());
    }

    @Test
    public void shouldReturnListOfBlackAndEmptyWhiteCharsAfterResetAndMove() {
        Go go = new Go(13);
        go.move("1A");
        go.move("2A");
        go.move("3A");
        go.reset();
        go.move("5A");
        List<String> expectedBlackCharsCoordinates = List.of("5A");
        List<String> expectedWhiteCharCoordinates = List.of();
        assertEquals(expectedWhiteCharCoordinates,go.getListOfWhiteCharsCoordinates());
        assertEquals(expectedBlackCharsCoordinates,go.getListOfBlackCharsCoordinates());
    }

    @Test
    public void shouldReturnListOfBlackAndWhiteAfterMultipleRollback() {
        Go go = new Go(13);
        go.move("1A");
        go.move("2A");
        go.move("3A");
        go.rollBack(1);
        go.move("5A");
        go.rollBack(1);
        List<String> expectedBlackCharsCoordinates = List.of("1A");
        List<String> expectedWhiteCharCoordinates = List.of("2A");
        assertEquals(expectedWhiteCharCoordinates,go.getListOfWhiteCharsCoordinates());
        assertEquals(expectedBlackCharsCoordinates,go.getListOfBlackCharsCoordinates());
    }
    @Test
    public void shouldReturn10JIsLeftMostBlackCharAnd11JIsLeftMostWhiteChar() {
        Go go = new Go(13);
        go.move("10J");
        go.move("11J");
        go.move("5J");
        go.move("4A");
        go.move("2A");
        String expectedLefMostBlackChar = "10J";
        String expectedLefMostWhiteChar = "11J";
        int indexOfLeftMostChar = 0;
        assertEquals(expectedLefMostBlackChar,go.getListOfBlackCharsCoordinates().get(indexOfLeftMostChar));
        assertEquals(expectedLefMostWhiteChar,go.getListOfWhiteCharsCoordinates().get(indexOfLeftMostChar));
    }

    @Test
    public void selfCapturedShouldReturnIllegalArgumentException() {
        Go go = new Go(9);
        assertThrows(IllegalArgumentException.class,() -> {
            go.move("9A","1A","8B","2A","9C","9B");
        });
    }


    @Test
    public void shouldReturnOnlyBlackCharsAfterCaptured() {
        Go go = new Go(5);
        go.move("2A");
        go.move("1A");
        go.move("1B");
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 x . . . .
                1 . x . . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnOnlyBlackCharsAfterCapturedTwoWhiteChars() {
        Go go = new Go(5);
        go.move("2A","1A","2B","1B","1C");
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 x x . . .
                1 . . x . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionBySelfCaptured() {
        Go go = new Go(5);
        assertThrows(IllegalArgumentException.class, () -> {
            go.move("2A","1A","2B","3A","1C","1B");
        });
    }

    @Test
    public void shouldReturnCorrectTurnAfterThrowArgumentExceptionBySelfCaptured() {
        Go go = new Go(5);
        assertThrows(IllegalArgumentException.class, () -> {
            go.move("2A","1A","2B","3A","1C","1B");
        });
        String expectedTurnAfterThrowException = "white";
        assertEquals(expectedTurnAfterThrowException,go.getTurn());
    }

    @Test
    public void shouldReturnCorrectTableAfterThrowArgumentExceptionBySelfCaptured() {
        Go go = new Go(5);
        assertThrows(IllegalArgumentException.class, () -> {
            go.move("2A","1A","2B","3A","1C","1B");
        });
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 o . . . .
                2 x x . . .
                1 o . x . .
                """;
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnCorrectListOfBlackCharsAfterThrowArgumentExceptionBySelfCaptured() {
        Go go = new Go(5);
        assertThrows(IllegalArgumentException.class, () -> {
            go.move("2A","1A","2B","3A","1C","1B");
        });
        List<String> expectedBlackChars = List.of("2A","2B","1C");
        assertEquals(expectedBlackChars,go.getListOfBlackCharsCoordinates());
    }

    @Test
    public void shouldReturnCorrectListOfWhiteCharsAfterThrowArgumentExceptionBySelfCaptured() {
        Go go = new Go(5);
        assertThrows(IllegalArgumentException.class, () -> {
            go.move("2A","1A","2B","3A","1C","1B");
        });
        List<String> expectedWhiteChars = List.of("3A","1A");
        assertEquals(expectedWhiteChars,go.getListOfWhiteCharsCoordinates());
    }

    @Test
    public void shouldReturnTableAfterCapturedTwoWhiteCharsAndMove() {
        Go go = new Go(5);
        go.move("2A","1A","2B","1B","1C");
        String expectedTableToString = """
                  A B C D E
                5 . . . . .
                4 . . . . .
                3 . . . . .
                2 x x . . .
                1 . . x o .
                """;
        go.move("1D");
        assertEquals(expectedTableToString,go.getBoardToString());
    }

    @Test
    public void shouldReturnOneBlackGroupWhenOneGroupWasCaptured() {
        Go go = new Go(19,19);
        go.move("1C","1A","1B","2B","15A","2C","15B","1D");
        String expectedBoard = """
                 A B C D E F G H J K L M N O P Q R S T
              19 . . . . . . . . . . . . . . . . . . .
              18 . . . . . . . . . . . . . . . . . . .
              17 . . . . . . . . . . . . . . . . . . .
              16 . . . . . . . . . . . . . . . . . . .
              15 x x . . . . . . . . . . . . . . . . .
              14 . . . . . . . . . . . . . . . . . . .
              13 . . . . . . . . . . . . . . . . . . .
              12 . . . . . . . . . . . . . . . . . . .
              11 . . . . . . . . . . . . . . . . . . .
              10 . . . . . . . . . . . . . . . . . . .
              9  . . . . . . . . . . . . . . . . . . .
              8  . . . . . . . . . . . . . . . . . . .
              7  . . . . . . . . . . . . . . . . . . .
              6  . . . . . . . . . . . . . . . . . . .
              5  . . . . . . . . . . . . . . . . . . .
              4  . . . . . . . . . . . . . . . . . . .
              3  . . . . . . . . . . . . . . . . . . .
              2  . o o . . . . . . . . . . . . . . . .
              1  o . . o . . . . . . . . . . . . . . .
                """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

    @Test
    public void shouldReturnOneBlackGroupWhenOneGroupWasCapturedInDownLeftCorner() {
        Go go = new Go(19,19);
        go.move("19T","19S","1A","18T");
        String expectedBoard = """
                 A B C D E F G H J K L M N O P Q R S T
              19 . . . . . . . . . . . . . . . . . o .
              18 . . . . . . . . . . . . . . . . . . o
              17 . . . . . . . . . . . . . . . . . . .
              16 . . . . . . . . . . . . . . . . . . .
              15 . . . . . . . . . . . . . . . . . . .
              14 . . . . . . . . . . . . . . . . . . .
              13 . . . . . . . . . . . . . . . . . . .
              12 . . . . . . . . . . . . . . . . . . .
              11 . . . . . . . . . . . . . . . . . . .
              10 . . . . . . . . . . . . . . . . . . .
              9  . . . . . . . . . . . . . . . . . . .
              8  . . . . . . . . . . . . . . . . . . .
              7  . . . . . . . . . . . . . . . . . . .
              6  . . . . . . . . . . . . . . . . . . .
              5  . . . . . . . . . . . . . . . . . . .
              4  . . . . . . . . . . . . . . . . . . .
              3  . . . . . . . . . . . . . . . . . . .
              2  . . . . . . . . . . . . . . . . . . .
              1  x . . . . . . . . . . . . . . . . . .
                """;
        assertEquals(expectedBoard,go.getBoardToString());
    }

}