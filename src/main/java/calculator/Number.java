package calculator;

public class Number {
    private static final String NOT_NUMBER_FORMAT_MESSAGE = "숫자만 입력해야합니다.";
    protected final int value;

    public Number(String number) {
        try {
            this.value = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_NUMBER_FORMAT_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
