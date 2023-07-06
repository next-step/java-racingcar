package racingcar.domain;

public class Position {

    private static final String NOT_POSITIVE_MESSAGE = "위치는 음수가 될 수 없습니다.";

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        validate(position);
        return new Position(position);
    }

    public int getPosition() {
        return position;
    }

    public void increase() {
        this.position++;
    }

    private static void validate(int position) {
        if (position < 0) {
            throw new RuntimeException(NOT_POSITIVE_MESSAGE);
        }
    }
}
