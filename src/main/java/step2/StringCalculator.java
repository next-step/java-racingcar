package step2;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String SEPARATOR = " ";

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("2 + 3 * 4 / 2");
        System.out.println(result);
    }

    public int calculate(String input) {

        //check
        inputCheck(input);

        // ready
        String[] inputArray = input.split(SEPARATOR);
        int result = Integer.parseInt(inputArray[0]);

        // calculate
        for (int i = 0; i < inputArray.length - 1; i += 2) {
            result = plus(result, Integer.parseInt(inputArray[i + 2]), inputArray[i + 1]);
            result = minus(result, Integer.parseInt(inputArray[i + 2]), inputArray[i + 1]);
            result = multiply(result, Integer.parseInt(inputArray[i + 2]), inputArray[i + 1]);
            result = division(result, Integer.parseInt(inputArray[i + 2]), inputArray[i + 1]);
        }

        return result;
    }

    private int plus(int result, int nextNumber, String calculateSymbol) {
        if ("+".equals(calculateSymbol)) {
            result += nextNumber;
        }
        return result;
    }

    private int minus(int result, int nextNumber, String calculateSymbol) {
        if ("-".equals(calculateSymbol)) {
            result -= nextNumber;
        }
        return result;
    }

    private int multiply(int result, int nextNumber, String calculateSymbol) {
        if ("*".equals(calculateSymbol)) {
            result *= nextNumber;
        }
        return result;
    }

    private int division(int result, int nextNumber, String calculateSymbol) {
        if ("/".equals(calculateSymbol)) {
            result /= nextNumber;
        }
        return result;
    }


    private void inputCheck(String input) throws IllegalArgumentException {

        // null , empty
        if (input == null || input.length() == 0 || input.isEmpty() || input.replaceAll(SEPARATOR, "").isEmpty()) {
            throw new IllegalArgumentException("Null Or Empty.");
        }

        String[] inputArray = input.split(SEPARATOR);


        if (inputArray.length < 3) {
            throw new IllegalArgumentException("Less of Minimum Calculate Expression.");
        }


        if (inputArray.length % 2 == 0) {
            throw new IllegalArgumentException("Unmatched Numbers with Operators");
        }


        for (int i = 0; i < inputArray.length; i += 2) {
            checkNumberString(inputArray[i]);
        }

        for (int i = 1; i < inputArray.length; i += 2) {
            checkCalculateSymbol(inputArray[i]);
        }
    }

    private void checkCalculateSymbol(String s) throws IllegalArgumentException {
        if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
            throw new IllegalArgumentException("Unmatched something at Operator Location.");
        }
    }

    private void checkNumberString(String s) throws IllegalArgumentException {
        if (!Pattern.matches("^[0-9]*$", s)) {
            throw new IllegalArgumentException("Unmatched something at Numbers Location.");
        }
    }


}
