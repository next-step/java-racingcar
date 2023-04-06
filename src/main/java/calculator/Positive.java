package calculator;

public class Positive {

    private static int number;

    public static int toInt(String value) {
        number = Integer.parseInt(value);
        validatePositive();
        return number;
    }

    private static void validatePositive() {
        if (number < 0) {
            throw new RuntimeException("입력값은 음수일 수 없습니다.");
        }
    }
}
