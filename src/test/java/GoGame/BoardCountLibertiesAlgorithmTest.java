package GoGame;


import model.BoardCountLibertiesAlgorithm;
import model.Go;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardCountLibertiesAlgorithmTest {

    @Test
    public void shouldReturnOneBlackGroupWith3Liberties() {
        Go go = new Go(19,19);
        go.move("1A","15A","2A");
        BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm = new BoardCountLibertiesAlgorithm(19,19,go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates(), go.getBoard());
        int expectedLiberties = 3;
        assertEquals(expectedLiberties,boardCountLibertiesAlgorithm.getBlackGroupsWithCountedLiberties().get(0).getLiberties());
    }

    @Test
    public void shouldReturnOneBlackGroupWith4Liberties() {
        Go go = new Go(19,19);
        go.move("1A","15A","2A","16A","3A");
        BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm = new BoardCountLibertiesAlgorithm(19,19,go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates(), go.getBoard());
        int expectedLiberties = 4;
        assertEquals(expectedLiberties,boardCountLibertiesAlgorithm.getBlackGroupsWithCountedLiberties().get(0).getLiberties());
    }


    @Test
    public void shouldReturnThreeWhiteGroupWhenFirstHave6LibertiesAfterCapturedBlack() {
        Go go = new Go(19,19);
        go.move("1C","1A","1B","2B","15A","2C","15B","1D");
        BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm = new BoardCountLibertiesAlgorithm(19,19,go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates(), go.getBoard());
        int expectedLiberties = 6;
        assertEquals(expectedLiberties,boardCountLibertiesAlgorithm.getWhiteGroupsWithCountedLiberties().get(0).getLiberties());
    }


    @Test
    public void shouldReturnOneBlackGroupWhenWith5LibertiesAfterCaptured() {
        Go go = new Go(19,19);
        go.move("1C","1A","1B","2B","15A","2C","15B","1D");
        BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm = new BoardCountLibertiesAlgorithm(19,19,go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates(), go.getBoard());
        int expectedLiberties = 5;
        assertEquals(expectedLiberties,boardCountLibertiesAlgorithm.getBlackGroupsWithCountedLiberties().get(0).getLiberties());
    }


    @Test
    public void shouldReturn3LibertiesOfGroupsOfBlackInHorizontalRowInLeftUpperCorner() {
        Go go = new Go(6);
        go.move("1A","1E","1B");
        int expectedLiberties = 3;
        BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm = new BoardCountLibertiesAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates(), go.getBoard());
        assertEquals(expectedLiberties,boardCountLibertiesAlgorithm.getBlackGroups().get(0).getLiberties());
    }

    @Test
    public void shouldReturn3LibertiesOfGroupsOfBlackInVerticalRowInLeftUpperCorner() {
        Go go = new Go(6);
        go.move("1A","1E","2A");
        int expectedLiberties = 3;
        BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm = new BoardCountLibertiesAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates(), go.getBoard());
        assertEquals(expectedLiberties,boardCountLibertiesAlgorithm.getBlackGroups().get(0).getLiberties());
    }

    @Test
    public void shouldReturn8LibertiesOfGroupBlackWhenTheCharsAreInTheMiddleOfBoard() {
        Go go = new Go(6);
        go.move("2C","6A","3C","6B","4C");
        int expectedLiberties = 8;
        BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm = new BoardCountLibertiesAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates(), go.getBoard());
        assertEquals(expectedLiberties,boardCountLibertiesAlgorithm.getBlackGroups().get(0).getLiberties());
    }

    @Test
    public void shouldReturnLibertiesFromTwoGroups() {
        Go go = new Go(6);
        go.move("1A","1F","1B","1D","4C");
        int expectedLibertiesOfFirstBlackGroup = 4;
        int expectedLibertiesOfSecondBlackGroup = 3;
        BoardCountLibertiesAlgorithm boardCountLibertiesAlgorithm = new BoardCountLibertiesAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates(), go.getBoard());
        assertEquals(expectedLibertiesOfFirstBlackGroup, boardCountLibertiesAlgorithm.getBlackGroups().get(0).getLiberties());
        assertEquals(expectedLibertiesOfSecondBlackGroup, boardCountLibertiesAlgorithm.getBlackGroups().get(1).getLiberties());
    }



}