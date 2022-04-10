package calculator;

public final class PositiveInteger {

    private final int number;

    PositiveInteger(String number) {
        this(Integer.parseInt(number));
    }

    PositiveInteger(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("음수(%d)는 허용하지 않습니다.", number));
        }
    }

    public int number() {
        return number;
    }
}
