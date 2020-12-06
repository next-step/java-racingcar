package calculator.domain;

public class CalculateNumber {
    private static final String VALID_EMPTY_NUMBER_MESSAGE = "숫자 값이 없습니다.";
    private static final String VALID_NO_NUMBER_MESSAGE = "숫자가 아닙니다.";

    private int number;

    public CalculateNumber(String number) {
        validCaculateNumber(number);
        this.number = parseNumber(number);
    }

    private void validCaculateNumber(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException(VALID_EMPTY_NUMBER_MESSAGE);
        }
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NO_NUMBER_MESSAGE);
        }
    }

    public int number() {
        return this.number;
    }
}
