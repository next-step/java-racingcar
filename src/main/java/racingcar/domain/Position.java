package racingcar.domain;

public class Position {
    private static final String MOVING_UNIT = "-";

    private String position;

    Position(String position) {
        this.position = position;
    }

    public void forward() {
        position += MOVING_UNIT;
    }

    public String show() {
        return this.position;
    }

    public int length() {
        return this.position.length();
    }
}
