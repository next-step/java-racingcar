package stringaddcalculator.domain;

public class PositiveInteger {
    private final int number;

    private PositiveInteger(int positiveInteger) {
        validate(positiveInteger);
        this.number = positiveInteger;
    }

    public static PositiveInteger of(final String inputString) {
        return new PositiveInteger(parseInteger(inputString));
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(final int inputNumber) {
        if (isNegative(inputNumber)) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

    private boolean isNegative(final int inputNumber) {
        return inputNumber < 0;
    }

    private static int parseInteger(final String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 양식만 입력 바랍니다.");
        }
    }
}
