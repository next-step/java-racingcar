package racing;

public class Position implements Comparable<Position> {
    private static final int DEFAULT_POSITION = 0;      // 디폴트값
    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(final int position) {
        this.position = position;
    }

    public void moveForward() {
        this.position++;
    }

    @Override
    public int compareTo(Position position) {
        return this.position - position.position;
    }

    public int getPosition() {
        return this.position;
    }
}
