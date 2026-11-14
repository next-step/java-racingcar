package calculator;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(String token) {
        int number = parseInt(token);
        validate(number);
        this.value = number;
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static int parseInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
