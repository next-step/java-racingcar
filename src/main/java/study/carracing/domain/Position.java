package study.carracing.domain;

public class Position {

    private static final int INITIAL_POSITION = 1;

    private int position;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void plusPosition() {
        position += 1;
    }

    public int compareToMaxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isSame(int maxPosition) {
        return position == maxPosition;
    }
}
