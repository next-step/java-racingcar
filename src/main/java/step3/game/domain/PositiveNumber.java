package step3.game.domain;

public class PositiveNumber {

    public static final String POSITIVE_EXCEPTION_MESSAGE = "입력은 양의 정수만 가능합니다. 입력 값: ";
    public static final String POSITIVE_NUMBER_REGEX = "^[1-9]\\d*$";

    public final int number;

    public PositiveNumber(String input) {
        if (isPositiveInteger(input)) {
            this.number = parseInt(input);
            return;
        }
        throw new RuntimeException(POSITIVE_EXCEPTION_MESSAGE + input);
    }

    private boolean isPositiveInteger(String str) {
        return str.matches(POSITIVE_NUMBER_REGEX);
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
