package calculator;

import calculator.exception.InvalidDenominatorException;
import calculator.exception.InvalidInputException;
import calculator.exception.NumericException;
import calculator.exception.OperatorException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CalculatorValidator {

    private static final Long INVALID_DENOMINATOR_VALUE = 0L;
    private static final String NUMBER_CONFIRM_REGEX = "[+-]?\\d*(\\.\\d+)?";

    private CalculatorValidator() {
    }

    private static final Set<String> ARITHMETIC_OPERATION = Collections
            .unmodifiableSet(new HashSet<>(Arrays.asList("+", "-", "*", "/")));


    public static void validateInputParam(String input) {
        if ((input == null) || ("".equals(input))) {
            throw new InvalidInputException();
        }
    }

    public static void validateOperator(String text) {
        if (!ARITHMETIC_OPERATION.contains(text)) {
            throw new OperatorException();
        }
    }

    public static void validateDenominator(long value) {
        if (value == INVALID_DENOMINATOR_VALUE) {
            throw new InvalidDenominatorException();
        }
    }

    public static void validateNumeric(String input) {
        if (!input.matches(NUMBER_CONFIRM_REGEX)) {
            throw new NumericException();
        }
    }

}
