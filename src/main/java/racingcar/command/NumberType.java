package racingcar.command;

public enum NumberType {

    ZERO(0), ONE(1), FOUR(4), FIVE(5), TEN(10);

    NumberType(int value) {
        this.value = value;
    }

    private final int value;

    public int value() {
        return value;
    }
}
