package step2;

import java.util.HashSet;
import java.util.Set;

public class StringCalculator {

    private static final String DELIMITER = " ";
    private static final Set<String> OPERATORS = new HashSet<>();
    private String[] textArray;

    public void setText(String text) {
        checkText(text);
        this.textArray = text.split(DELIMITER);
        checkOperator(textArray);
    }

    public void checkText(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkOperator(String[] textArray) {
        for (int i = 1; i < textArray.length; i += 2) {
            if (!OPERATORS.contains(textArray[i])) {
                throw new IllegalArgumentException();
            }
        }
    }

    public StringCalculator() {
        OPERATORS.add("+");
        OPERATORS.add("-");
        OPERATORS.add("*");
        OPERATORS.add("/");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int calculate() {
        int result = Integer.parseInt(textArray[0]);

        for (int i = 1; i < textArray.length; i += 2) {
            int nextNum = Integer.parseInt(textArray[i + 1]);

            switch (textArray[i]) {
                case "+":
                    result = add(result, nextNum);
                    break;
                case "-":
                    result = subtract(result, nextNum);
                    break;
                case "*":
                    result = multiply(result, nextNum);
                    break;
                case "/":
                    result = divide(result, nextNum);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        return result;
    }
}