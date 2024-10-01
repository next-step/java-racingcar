package step3;

public class Position {
    private static final int INITIAL_POSITION = 0;
    private int position;

    public Position() {
        position = INITIAL_POSITION;
    }

    public void add() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }

}
