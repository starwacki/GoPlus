package GoGame;


import model.Go;
import model.Move;
import model.MoveTurn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {

    private boolean areTablesTheSame(char[][] tablesExpected, char[][] actualTable) {
     if (tablesExpected.length!=actualTable.length) return false;
     if (tablesExpected[0].length!=actualTable[0].length) return false;
        for (int i = 0; i < tablesExpected.length; i++) {
            for (int j = 0; j < tablesExpected[i].length; j++) {
                if (tablesExpected[i][j]!=actualTable[i][j]) return false;
            }
        }
        return true;
    }

    @Test
    public void shouldReturnTheSames5x5EmptyTables() {
        String board5x5String = """
                  A B C D E
                1 . . . . .
                2 . . . . .
                3 . . . . .
                4 . . . . .
                5 . . . . .
                """;
        Move move = new Move("2A", MoveTurn.BLACK,board5x5String);
        char[][] emptyBoard = new Go(5).getBoard();
        assertTrue(areTablesTheSame(emptyBoard, move.parseActualTableStringToBoardTable()));
    }

    @Test
    public void shouldReturnTheSame6x5EmptyBoards() {
        String board5x6String = """
                  A B C D E
                1 . . . . .
                2 . . . . .
                3 . . . . .
                4 . . . . .
                5 . . . . .
                6 . . . . .
                """;
        Move move = new Move("2A", MoveTurn.BLACK,board5x6String);
        char[][] emptyBoard = new Go(6,5).getBoard();
        assertTrue(areTablesTheSame(emptyBoard, move.parseActualTableStringToBoardTable()));
    }

    @Test
    public void shouldReturnTheSame5x6EmptyBoards() {
        String board5x6String = """
                  A B C D E F
                1 . . . . . .
                2 . . . . . .
                3 . . . . . .
                4 . . . . . .
                5 . . . . . .
                """;
        Move move = new Move("2A", MoveTurn.BLACK,board5x6String);
        char[][] emptyBoard = new Go(5,6).getBoard();
        assertTrue(areTablesTheSame(emptyBoard, move.parseActualTableStringToBoardTable()));
    }
    @Test
    public void shouldReturnTheSame9X10EmptyBoards() {
        String board9x10String = """
                  A B C D E F G H I J
                1 . . . . . . . . . .
                2 . . . . . . . . . .
                3 . . . . . . . . . .
                4 . . . . . . . . . .
                5 . . . . . . . . . .
                6 . . . . . . . . . .
                7 . . . . . . . . . .
                8 . . . . . . . . . .
                9 . . . . . . . . . .
                """;
        Move move = new Move("2A", MoveTurn.BLACK,board9x10String);
        char[][] emptyBoard = new Go(9,10).getBoard();
        assertTrue(areTablesTheSame(emptyBoard, move.parseActualTableStringToBoardTable()));
    }

    @Test
    public void shouldReturnTheSame10X9EmptyBoards() {
        String board10X9String = """
                   A B C D E F G H I
                1  . . . . . . . . .
                2  . . . . . . . . .
                3  . . . . . . . . .
                4  . . . . . . . . .
                5  . . . . . . . . .
                6  . . . . . . . . .
                7  . . . . . . . . .
                8  . . . . . . . . .
                9  . . . . . . . . .
                10 . . . . . . . . .
                """;
        Move move = new Move("2A", MoveTurn.BLACK,board10X9String);
        char[][] emptyBoard = new Go(10,9).getBoard();
        assertTrue(areTablesTheSame(emptyBoard, move.parseActualTableStringToBoardTable()));
    }

    @Test
    public void shouldReturnTheSame10X9EmptyBoard() {
        String board10X9String = """
                   A B C D E F G H I
                1  . . . . . . . . .
                2  . . . . . . . . .
                3  . . . . . . . . .
                4  . . . . . . . . .
                5  . . . . . . . . .
                6  . . . . . . . . .
                7  . . . . . . . . .
                8  . . . . . . . . .
                9  . . . . . . . . .
                10 . . . . . . . . .
                """;
        Move move = new Move("2A", MoveTurn.BLACK,board10X9String);
        char[][] emptyBoard = new Go(10,9).getBoard();
        assertTrue(areTablesTheSame(emptyBoard, move.parseActualTableStringToBoardTable()));
    }

}
