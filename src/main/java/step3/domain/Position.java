package step3.domain;

public class Position {

    private final int DEFAULT_MOVE_POINT = 1;

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position move() {
        return new Position(this.position + DEFAULT_MOVE_POINT);
    }

    public int getPosition() {
        return position;
    }
}
