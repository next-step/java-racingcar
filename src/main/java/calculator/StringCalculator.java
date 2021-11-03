package calculator;

import validator.ValidationChecker;

public class StringCalculator {

    private final ValidationChecker validationChecker;
    private final Calculator calculator;

    public StringCalculator(ValidationChecker validator, Calculator calculator) {
        this.validationChecker = validator;
        this.calculator = calculator;
    }

    public int calculate(String input) {
        validationChecker.check(input);
        return calculator.calculation(input);
    }
}
