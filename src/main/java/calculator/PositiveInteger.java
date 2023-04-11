package calculator;

public class PositiveInteger {
    public static final String NUMBER_CHECK_REGEX = "[-+]?\\d*\\.?\\d+";
    public static final int ZERO = 0;
    private final int number;

    public PositiveInteger(String input) {
        if (!isNumber(input)) {
            throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다.");
        }

        int number = Integer.parseInt(input);
        if (number < ZERO) {
            throw new RuntimeException("음수가 포함되어 있습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private static boolean isNumber(String input) {
        return input != null && input.matches(NUMBER_CHECK_REGEX);
    }
}
