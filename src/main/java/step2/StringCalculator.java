package step2;

public class StringCalculator {

    public static void calculate(String input) {
        validate(input);
    }

    private static void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(CalculatorException.INPUT_NULL);
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException(CalculatorException.INPUT_BLANK);
        }
    }
}
