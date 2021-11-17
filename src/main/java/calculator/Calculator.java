package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
    public static int compute(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input must not null or blank");
        }

        List<String> elements = new LinkedList<>(Arrays.asList(input.split(" ")));

        Number left = new Number(popFirst(elements));
        while (elements.size() != 0) {
            String operator = popFirst(elements);
            Number right = new Number(popFirst(elements));

            left = operate(left, operator, right);
        }

        return left.number;
    }

    private static Number operate(Number left, String operator, Number right) {
        switch (operator) {
            case "+":
                return left.add(right);
            case "-":
                return left.subtract(right);
            case "*":
                return left.multiply(right);
            case "/":
                return left.divide(right);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private static String popFirst(List<String> list) {
        return list.remove(0);
    }
}
