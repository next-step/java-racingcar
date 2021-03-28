package calculator.utils;

import calculator.exceptions.InvalidOperatorException;
import calculator.exceptions.InvalidValueException;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtil {

    private ValidationUtil() { }

    public static void checkInvalidValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new InvalidValueException();
        }
    }

    public static void checkInvalidOperator(String value) {
        List<String> operationTypes = new ArrayList<>();
        operationTypes.add("+");
        operationTypes.add("-");
        operationTypes.add("/");
        operationTypes.add("*");

        if (!operationTypes.contains(value)) {
            throw new InvalidOperatorException();
        }
    }
}
