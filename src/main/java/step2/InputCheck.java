package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCheck {

    private final static Pattern pattern = Pattern.compile("^[0-9]*$");
    public static final String SEPARATOR = " ";
    public static String input;
    public static String[] inputArray;

    public InputCheck(String input) throws IllegalArgumentException {

        if (null == input) {
            throw new IllegalArgumentException("Null Or Empty.");
        }

        this.input = input;
        this.inputArray = input.split(SEPARATOR);
    }

    public void inputCheck() {
        emptyCheck(input);
        minimumExpressionCheck(inputArray);
        matchingNumbersAndOperators(inputArray);
        numberStringCheck(inputArray);
        calculateSymbolCheck(inputArray);
    }

    public static void emptyCheck(String input) throws IllegalArgumentException {

        // null , empty
        if (input == null || input.length() == 0 || input.replaceAll(SEPARATOR, "").isEmpty()) {
            throw new IllegalArgumentException("Null Or Empty.");
        }

    }

    public static void minimumExpressionCheck(String[] inputArray) throws IllegalArgumentException {

        if (inputArray.length < 3) {
            throw new IllegalArgumentException("Less of Minimum Calculate Expression.");
        }

    }

    public static void matchingNumbersAndOperators(String[] inputArray) throws IllegalArgumentException {
        if (inputArray.length % 2 == 0) {
            throw new IllegalArgumentException("Unmatched Numbers with Operators");
        }
    }

    public static void numberStringCheck(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i += 2) {
            checkNumberString(inputArray[i]);
        }
    }

    public static void calculateSymbolCheck(String[] inputArray) {
        for (int i = 1; i < inputArray.length; i += 2) {
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



