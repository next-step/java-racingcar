package racingcar.domain;

public class Position {

    private final int position;

    private final int DEFAULT_MOVE_POINT = 1;

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
