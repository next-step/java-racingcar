package calculator;

public class PositiveNumber extends Number {
    private static final String NOT_NEGATIVE_NUMBER_MESSAGE = "숫자가 음수일 수 없습니다.";
    private static final int ZERO = 0;

    public PositiveNumber(String number) {
        super(number);
        validatePositiveNumber();
    }

    private void validatePositiveNumber() {
        if (isNegative()) throw new RuntimeException(NOT_NEGATIVE_NUMBER_MESSAGE);
    }

    private boolean isNegative() {
        return value < ZERO;
    }
}
