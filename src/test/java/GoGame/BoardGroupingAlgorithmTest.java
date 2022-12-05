package GoGame;


import model.BoardGroupingAlgorithm;
import model.Go;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class BoardGroupingAlgorithmTest {

    @Test
    public void shouldReturnOneGroupOfBlacks () {
        List<String> blackCoordinates = List.of("1A","2A","3A");
        List<String> whiteCoordinates = List.of();
        int expectedGroups = 1;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(5,5,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups,boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnTwoGroupsOfBlacks () {
        List<String> blackCoordinates = List.of("1A","3A");
        List<String> whiteCoordinates = List.of();
        int expectedGroups = 2;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(5,5,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups,boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnTwoGroupOfBlacksWhenWhiteCharIsNext () {
        List<String> blackCoordinates = List.of("1A","3A");
        List<String> whiteCoordinates = List.of("2A");
        int expectedGroups = 2;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(5,5,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups,boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnOneGroupOfBlacksWhenBlackGetFullFirstLine () {
        List<String> blackCoordinates = List.of("1A","2A","3A","4A","5A");
        List<String> whiteCoordinates = List.of();
        int expectedGroups = 1;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(5,5,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups,boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnOneGroupsOfWhenBlackGet5CooridnatesNextToTheir () {
        List<String> blackCoordinates = List.of("1A","1B","2A","2B","2C");
        List<String> whiteCoordinates = List.of();
        int expectedGroups = 1;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(5,5,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups,boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnThreeGroupsOfBlackWhenOneBlackGroupAreSurroundedByWhites() {
        List<String> blackCoordinates = List.of("1A","1B","2A","2B","2C","4A","4B","4C","3D");
        List<String> whiteCoordinates = List.of("3A","3B","3C","2D");
        int expectedGroups = 3;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(5,5,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups,boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnFourGroupsOfBlackWhenOneBlackGroupAreSurroundedByWhites() {
        List<String> blackCoordinates = List.of("1A","1B","2A","2B","2C","4A","4B","4C","3D","5E");
        List<String> whiteCoordinates = List.of("3A","3B","3C","2D","3C");
        int expectedGroups = 4;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(5,5,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups,boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnThreeGroupsOfWhitesWhenOneBlackGroupAreSurroundedByWhites() {
        List<String> blackCoordinates = List.of("1A","1B","2A","2B","2C","4A","4B","4C","3D");
        List<String> whiteCoordinates = List.of("3A","3B","3C","2D","3C");
        int expectedGroups = 3;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(5,5,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups, boardGroupingAlgorithm.getWhiteGroups().size());
    }

    @Test
    public void shouldReturnOneGroupOfBlacksWhenTheirInDownRightCount() {
        List<String> blackCoordinates = List.of("4E","5C","5D","5E");
        List<String> whiteCoordinates = List.of("3A","3B","3C","2D","3C");
        int expectedGroups = 1;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(5,5,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups, boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnOneGroupOfBlacksWhenBoardHorizontalLineHaveBiggerLettersThanI() {
        List<String> blackCoordinates = List.of("19T","18T","19S");
        List<String> whiteCoordinates = List.of();
        int expectedGroups = 1;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(19,19,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups, boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnTwoGroupOfBlacksWhenBoardHorizontalLineHaveBiggerLettersThanI() {
        List<String> blackCoordinates = List.of("19T","18T","19S","17Q");
        List<String> whiteCoordinates = List.of();
        int expectedGroups = 2;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(19,19,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups, boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnThreeGroupsOfBlacksWhenBoardHorizontalLineHaveBiggerLettersThanI() {
        List<String> blackCoordinates = List.of("19T","18T","19S","17Q","1A","2A","3A");
        List<String> whiteCoordinates = List.of();
        int expectedGroups = 3;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(19,19,whiteCoordinates,blackCoordinates);
        assertEquals(expectedGroups, boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnTwoGroupsOfBlackChars() {
        Go go = new Go(6);
        go.move("6F","1A","1C");
        int expectedNumberOfBlackGroups = 2;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedNumberOfBlackGroups,boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnThreeGroupsOfBlackChars() {
        Go go = new Go(6);
        go.move("6F","1A","4B","2B","4F");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        int expectedNumberOfBlackGroups = 3;
        assertEquals(expectedNumberOfBlackGroups,boardGroupingAlgorithm.getBlackGroups().size());
    }

    @Test
    public void shouldReturnTwoGroupsOfBlackAndWhiteChars() {
        Go go = new Go(6);
        go.move("1A","1B","1C","1D");
        int expectedNumberOfGroups = 2;
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedNumberOfGroups,boardGroupingAlgorithm.getBlackGroups().size());
        assertEquals(expectedNumberOfGroups,boardGroupingAlgorithm.getWhiteGroups().size());
    }

    @Test
    public void shouldReturnTwoGroupsOfBlackCoordinates() {
        Go go = new Go(6);
        go.move("1A","1B","2A","1D","5F","1C","6F");
        List<String> firstGroupExpectedCoordinates  = List.of("6F","5F");
        List<String> secondGroupExpectedCoordinates  = List.of("2A","1A");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(firstGroupExpectedCoordinates,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
        assertEquals(secondGroupExpectedCoordinates,boardGroupingAlgorithm.getBlackGroups().get(1).getMoves());
    }



    @Test
    public void shouldReturnTwoGroupsOfBlackCoordinatesAfterRollback() {
        Go go = new Go(6);
        go.move("1A","1B","2A","1D","5F","1C","6F");
        List<String> firstGroupExpectedCoordinates  = List.of("5F");
        List<String> secondGroupExpectedCoordinates  = List.of("2A","1A");
        go.rollBack(1);
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(firstGroupExpectedCoordinates,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
        assertEquals(secondGroupExpectedCoordinates,boardGroupingAlgorithm.getBlackGroups().get(1).getMoves());
    }

    @Test
    public void shouldReturnSingleCharInRightUpperCorner() {
        Go go = new Go(6);
        go.move("6F");
        List<String> expectedGroup = List.of("6F");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnOneGroupOfBlackCharsWithTwoCharsInOneHorizontalLine() {
        Go go = new Go(6);
        go.move("1A","1C","1B");
        List<String> expectedGroup = List.of("1A","1B");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnOneGroupOfBlackCharsWithThreeCharsInOneHorizontalLine() {
        Go go = new Go(6);
        go.move("1A","2A","1B","2C","1C");
        List<String> expectedGroup = List.of("1A","1B","1C");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnOneGroupOfBlackCharsWithTwoCharsInOneVerticalLine() {
        Go go = new Go(6);
        go.move("1A","3A","2A");
        List<String> expectedGroup = List.of("2A","1A");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnOneGroupOfBlackCharsWithThreeCharsInOneVerticalLine() {
        Go go = new Go(6);
        go.move("1A","1B","2A","2B","3A");
        List<String> expectedGroup = List.of("3A","2A","1A");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnOneGroupOfBlackCharsInTheLeftUpperCorner() {
        Go go = new Go(6);
        go.move("1A","1F","1B","2B","2A");
        List<String> expectedGroup = List.of("2A","1A","1B");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturn2x2GroupOfBlackCharsInLeftUpperCorner() {
        Go go = new Go(6);
        go.move("1A","1F","1B","3B","2A","4F","2B");
        List<String> expectedGroup = List.of("2A","1A","1B","2B");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnGroupOfBlackCharsWithTwoCharsInVerticalLineInRightDownCorner() {
        Go go = new Go(6);
        go.move("1F","1A","2F");
        List<String> expectedGroup = List.of("2F","1F");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnGroupOfBlackCharsWithTwoCharsInHorizontalLineInRightCorner() {
        Go go = new Go(6);
        go.move("1F","1A","1E");
        List<String> expectedGroup = List.of("1E","1F");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnGroupOfBlackCharsWithThreeCharsInRightDownCorner() {
        Go go = new Go(6);
        go.move("1F","1A","1E","1B","2F");
        List<String> expectedGroup = List.of("2F","1F","1E");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturn2x2GroupOfBlackCharsInRightDownCorner() {
        Go go = new Go(6);
        go.move("1F","1A","1E","2A","2F","3A","2E");
        List<String> expectedGroup = List.of("2E","1E","1F","2F");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnGroupOfBlacksWithTwoCharsInVerticalLineInLeftUpperCorner() {
        Go go = new Go(6);
        go.move("5A","1A","6A");
        List<String> expectedGroup = List.of("6A","5A");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnGroupOfBlacksWithTwoCharsInHorizontalLineInLeftUpperCorner() {
        Go go = new Go(6);
        go.move("6A","1A","6B");
        List<String> expectedGroup = List.of("6A","6B");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturn2X2GroupOfBlacksInLeftDownCorner() {
        Go go = new Go(6);
        go.move("6A","1A","6B","1B","5A","1C","5B");
        List<String> expectedGroup = List.of("6A","5A","5B","6B");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturn2X2GroupOfBlacksWithTwoCharsInLeftDownCorner() {
        Go go = new Go(6);
        go.move("6A","1A","6B","1B","5A","1C");
        List<String> expectedGroup = List.of("6A","5A","6B");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturnGroupOfBlacksWithTwoCharsInVerticalLineInRightUpperCorner() {
        Go go = new Go(6);
        go.move("5F","1A","6F");
        List<String> expectedGroup = List.of("6F","5F");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }


    @Test
    public void shouldReturnGroupOfBlacksWithTwoCharsInHorizontalLineInRightUpperCorner() {
        Go go = new Go(6);
        go.move("6E","1A","6F");
        List<String> expectedGroup = List.of("6E","6F");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

    @Test
    public void shouldReturn2X2GroupOfBlacksInRightUpperCorner() {
        Go go = new Go(6);
        go.move("6E","1A","6F","1B","5E","1C","5F");
        List<String> expectedGroup = List.of("6E","5E","5F","6F");
        BoardGroupingAlgorithm boardGroupingAlgorithm = new BoardGroupingAlgorithm(go.getSize().get("height"),go.getSize().get("width"),go.getListOfWhiteCharsCoordinates(),go.getListOfBlackCharsCoordinates());
        assertEquals(expectedGroup,boardGroupingAlgorithm.getBlackGroups().get(0).getMoves());
    }

}
