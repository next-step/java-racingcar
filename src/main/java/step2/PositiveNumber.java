package step2;

public class PositiveNumber {

    private static final String NUMBER_REGEX = "^-?\\d*\\.{0,1}\\d+$";
    private final int number;

    private PositiveNumber(int number) {
        this.number = number;
    }

    public static PositiveNumber of(String value) {
        return new PositiveNumber(toInt(value));
    }

    public int getNumber() {
        return this.number;
    }

    private static int toInt(String value) {
        validNumber(value);
        int number = Integer.parseInt(value);
        validatePositive(number);
        return number;
    }

    private static void validNumber(String value) {
        if (!value.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(String.format("숫자만 허용합니다(입력값 : %s).", value));
        }
    }

    private static void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("음수(%d)는 허용하지 않습니다.", number));
        }
    }
}
