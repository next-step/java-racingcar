package racingcar.command;

public enum NumberType {

    MINUS_ONE(-1), ZERO(0), ONE(1), THREE(3), FOUR(4), FIVE(5), TEN(10);

    NumberType(int value) {
        this.value = value;
    }

    private final int value;

    public int value() {
        return value;
    }
}
