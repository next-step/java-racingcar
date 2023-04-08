package step3.component;

public class NumberValidator {
    private static final int positiveMinimum = 1;

    public static boolean isPositive(int number) {
        return number >= positiveMinimum;
    }

    public static int validateCarAmount(int number) {
        if (!isPositive(number)) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
        return number;
    }

    public static int validateTryNumber(int number) {
        if (!isPositive(number)) {
            throw new IllegalArgumentException("1 이상만 입력이 가능합니다");
        }
        return number;
    }
}
