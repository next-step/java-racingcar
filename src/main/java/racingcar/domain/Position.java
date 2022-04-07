package racingcar.domain;

public class Position {

    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
