package racing.domain;

public class Position {

    private static final Integer DEFAULT_POSITION = 0;

    private int position;

    public Position() {
        this.position = DEFAULT_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public boolean isSameWith(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }
}
