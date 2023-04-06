package calculator;

public class PositiveInteger {
    private final int number;

    public PositiveInteger(String input) {
        if (!isNumber(input)) {
            throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다.");
        }
        this.number = Integer.parseInt(input);
    }

    public int getNumber() {
        return number;
    }

    private static boolean isNumber(String input) {
        return input != null && input.matches("[-+]?\\d*\\.?\\d+");
    }
}
