package step2.calculator;

class StringAddCalculatorInputValidatorException extends RuntimeException {

    public StringAddCalculatorInputValidatorException(String message) {
        super(message);
    }
}

public class StringAddCalculatorInputValidator {

    public static void validate(String input) {
        if (input == null || input.isEmpty()) {
            // "null" and "Empty String" are valid in StringAddCalculator
            return;
        }

        if (input.isBlank()) {
            throw new StringAddCalculatorInputValidatorException("Input cannot be blank");
        }
    }
}
