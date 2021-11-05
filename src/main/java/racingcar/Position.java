package racingcar;

public class Position {
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public Position move(int moveValue) {
        return new Position(this.position + moveValue);
    }
}
