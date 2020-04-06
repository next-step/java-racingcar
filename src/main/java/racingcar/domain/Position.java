package racingcar.domain;

public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position이 0보다 작습니다");
        }
    }

    public int getPosition() {
        return position;
    }

    public Position increase() {
        return new Position(position + 1);
    }
}
