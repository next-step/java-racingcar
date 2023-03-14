package racing;

public class Position {
    private static final int DEFAULT_POSITION = 0;      // 디폴트값
    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public void moveForward() {
        this.position++;
    }

    public int positionOrder(Position thisPosition, Position objectPosition) {
        return thisPosition.position - objectPosition.position;
    }

    public int getPosition() {
        return this.position;
    }
}
