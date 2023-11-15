package step4.model;

public class Position {

    private final int position;
    private static final int DEFAULT_MOVE_POSITION = 1;

    public Position(int position) {
        this.position = position;
    }

    public Position move() {
        return new Position(this.position + DEFAULT_MOVE_POSITION);
    }

    public int getCurrentStatus() {
        return this.position;
    }
}
