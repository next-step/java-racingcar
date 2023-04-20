package CarRacing.domain;

public class Position {
    private static final int INITIAL_POSITION = 1;

    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public Position(int number) {
        this.position = number;
    }

    public void move(int number) {
        this.position += number;
    }

    public int currentPosition() {
        return this.position;
    }
}
