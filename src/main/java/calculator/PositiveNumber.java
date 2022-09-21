package calculator;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(int number) {
        validate(number);

        this.number = number;
    }

    private static void validate(int number) {
        if (isNegative(number)) {
            throw new RuntimeException();
        }
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    public int getNumber() {
        return number;
    }
}
