package calculator;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(int number) {
        if (isNegative(number)) {
            throw new RuntimeException();
        }

        this.number = number;
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    public int getNumber() {
        return number;
    }
}
