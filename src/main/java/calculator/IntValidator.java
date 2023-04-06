package calculator;

public class IntValidator {
    public static boolean isPositive(int number) {
        if (number < 0) {
            throw new RuntimeException("계산기의 숫자는 양수여야 합니다.");
        }
        return true;
    }
}
