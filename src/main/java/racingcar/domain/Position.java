package racingcar.domain;

public class Position {
    public static final String MOVING_UNIT = "-";

    private String position;

    Position(String position) {
        this.position = position;
    }

    public void forward(String movingUnit) {
        position += movingUnit;
    }

    public String show() {
        return this.position;
    }

    public int length() {
        return this.position.length();
    }
}
