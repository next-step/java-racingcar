package step2;

public class PositiveNumber {
    private final int value;

    public PositiveNumber(String token) {
        int number = parse(token);
        validatePositive(number);
        value = number;
    }

    private void validatePositive(int number) {
        if (number < 0) throw new RuntimeException();
    }

    private int parse(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    public int value() {
        return value;
    }
}
