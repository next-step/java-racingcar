package calculator;

public class NonNegativeNumber {
    private final int value;

    public NonNegativeNumber(String input) {
        if (input.isEmpty()) {
            value = 0;
            return;
        }

        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new RuntimeException("only numeric expressions are allowed.", ne);
        }

        if (value < 0) {
            throw new RuntimeException("value can not be negative.");
        }
    }

    public int getValue() {
        return value;
    }
}
