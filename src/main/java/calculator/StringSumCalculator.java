package calculator;

public class StringSumCalculator {

    public static final String DEFAULT_SEPARATOR = ",|:";

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        for (String s : input.split(DEFAULT_SEPARATOR)) {
            NonNegativeNumber p = new NonNegativeNumber(s);
            result += p.getValue();
        }
        return result;
    }
}

class NonNegativeNumber {
    private final int value;

    public NonNegativeNumber(String input) {
        if (input.isEmpty()) {
            value = 0;
            return;
        }

        value = Integer.parseInt(input);

        if (value < 0) {
            throw new RuntimeException("value can not be negative.");
        }
    }

    public int getValue() {
        return value;
    }
}
