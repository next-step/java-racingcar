package racingGame;

public class Position {

    private int position;

    public Position() {
        this.position = 0;
    }

    public void add() {
        position++;
    }

    public int getValue() {
        return position;
    }
}
