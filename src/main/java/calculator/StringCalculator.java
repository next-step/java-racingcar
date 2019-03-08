package calculator;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    static final String ADD = "+";
    static final String SUBTRACT = "-";
    static final String MULTIPLY = "*";
    static final String DIVIDE = "/";

    static int calculate(String text) {
        String[] values = text.split(" ");
        int prev, next;
        prev = parseInt(values[0]);
        for (int i = 0; i < values.length - 2; i++) {
            next = parseInt(values[i + 2]);
            prev = matchOperator(prev, values[i + 1], next);
        }
        return prev;
    }

    static int matchOperator(int prev, String operator, int next) {
        if (operator.equals(ADD))
            return add(prev, next);
        if (operator.equals(SUBTRACT))
            return subtract(prev, next);
        if (operator.equals(MULTIPLY))
            return multiply(prev, next);
        if (operator.equals(DIVIDE))
            return divide(prev, next);
        return 0;
    }

    static int add(int prev, int next) {
        return prev + next;
    }

    static int subtract(int prev, int next) {
        return prev - next;
    }

    static int multiply(int prev, int next) {
        return prev * next;
    }

    static int divide(int prev, int next) {
        return prev / next;
    }
}
