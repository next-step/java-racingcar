package calculator;

public final class Number {
    private static final String NOT_POSITIVE_MESSAGE = "음수는 입력할 수 없습니다.";
    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private static final String OVERFLOW_MESSAGE = "계산 결과가 정수 범위를 벗어났습니다.";
    private int number;

    private Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static Number from(String value) {
        return new Number(toInt(value));
    }

    public static Number from(int value) {
        return new Number(value);
    }

    public int getNumber() {
        return number;
    }

    public void plus(Number number) {
        this.number += number.getNumber();
        validateOverflow();
    }

    private void validateOverflow() {
        if (this.number < 0) {
            throw new ArithmeticException(OVERFLOW_MESSAGE);
        }
    }

    private void validateNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_MESSAGE);
        }
    }

    private static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }
}
