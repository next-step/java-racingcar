package stringcalculator;

public class PositiveNumber {

    private final int number;

    private PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public static PositiveNumber CreatePositiveNumber(String string) {
        return new PositiveNumber(getInteger(string));
    }

    private static int getInteger(String string) {
        return Integer.parseInt(string);
    }

    int getNumber() {
        return number;
    }
}
