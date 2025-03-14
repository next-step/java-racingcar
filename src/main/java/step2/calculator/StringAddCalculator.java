package step2.calculator;

public class StringAddCalculator {

    public static int calculate(String input) {
        validate(input);
        StringAddCalculatorToken[] tokens = split(input);
        return sum(tokens);
    }

    private static void validate(String input) {
        StringAddCalculatorInputValidator.validate(input);
    }

    private static StringAddCalculatorToken[] split(String input) {
        return StringAddCalculatorTokenGenerator.generateTokens(input);
    }

    private static int sum(StringAddCalculatorToken[] tokens) {
        return StringAddCalculatorTokenCalculator.sum(tokens);
    }

}
