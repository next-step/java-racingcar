package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCheck {

    private final static Pattern pattern = Pattern.compile("^[0-9]*$");
    private final static int MINIMUM_EXPRESSION_SIZE = 3;
    private final static int CONDITION_OF_EXPRESSION = 2;
    private final static int STEP_OF_NUMBER_AND_SYMBOL = 2;

    public static void checkEmpty(String input, String separator) throws IllegalArgumentException {
        // null , empty
        if (input == null || input.length() == 0 || input.replaceAll(separator, "").isEmpty()) {
            throw new IllegalArgumentException("Null Or Empty.");
        }
    }

    public static void checkMinimumExpression(String[] inputArray) throws IllegalArgumentException {
        if (inputArray.length < MINIMUM_EXPRESSION_SIZE) {
            throw new IllegalArgumentException("Less of Minimum Calculate Expression.");
        }

    }

    public static void checkMatchingNumbersAndOperators(String[] inputArray) throws IllegalArgumentException {
        if (inputArray.length % CONDITION_OF_EXPRESSION == 0) {
            throw new IllegalArgumentException("Unmatched Numbers with Operators");
        }
    }

    public static void checkNumberString(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i += STEP_OF_NUMBER_AND_SYMBOL) {
            checkNumberString(inputArray[i]);
        }
    }

    public static void checkCalculateSymbol(String[] inputArray) {
        for (int i = 1; i < inputArray.length; i += STEP_OF_NUMBER_AND_SYMBOL) {
            checkCalculateSymbol(inputArray[i]);
        }
    }

    private static void checkCalculateSymbol(String s) throws IllegalArgumentException {
        if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
            throw new IllegalArgumentException("Unmatched something at Operator Location.");
        }
    }

    private static void checkNumberString(String s) throws IllegalArgumentException {
        Matcher m = pattern.matcher(s);
        if (!m.matches()) {
            throw new IllegalArgumentException("Unmatched something at Numbers Location.");
        }
    }
}



