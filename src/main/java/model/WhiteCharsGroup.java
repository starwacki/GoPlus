package model;
import java.util.List;

public class WhiteCharsGroup {
    private List<String> moves;
    private int liberties;

    public WhiteCharsGroup(List<String> moves) {
        this.moves = moves;
    }

    public List<String> getMoves() {
        return moves;
    }

    public int getLiberties() {
        return liberties;
    }

    public void setLiberties(int liberties) {
        this.liberties = liberties;
    }

}
