package step3.component;

public class NumberValidator {
    private static int positiveMinimum = 1;

    public static boolean isPositive(int number) {
        return number >= positiveMinimum;
    }

    public static int throwIfNotPositive(int number) {
        if (!isPositive(number)) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }

        return number;
    }
}
