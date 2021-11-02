package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CalculatorValidator {
    private static final Set<String> ARITHMETIC_OPERATION = Collections
            .unmodifiableSet(new HashSet<>(Arrays.asList("+", "-", "*", "/")));


    public static void validateInputParam(String input) {
        if (input == null || "".equals(input)) {
           throw new IllegalArgumentException();
        }
    }

    public static void validateFormula(String text) {
        if (!ARITHMETIC_OPERATION.contains(text)) {
            throw new IllegalArgumentException();
        }
    }
}
