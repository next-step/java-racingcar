package step2;

public class PositiveNumber {

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
        int number = Integer.parseInt(value);
        validatePositive(number);
        return number;
    }

    private static void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("음수(%d)는 허용하지 않습니다.", number));
        }
    }
}
