package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int compute(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input must not null or blank");
        }

        List<String> elements = new ArrayList<>(Arrays.asList(input.split(" ")));

        while (elements.size() != 1) {
            int left = Integer.parseInt(elements.remove(0));
            String operator = elements.remove(0);
            int right = Integer.parseInt(elements.remove(0));

            int result = operate(left, operator, right);
            elements.add(0, Integer.toString(result));
        }

        return Integer.parseInt(elements.get(0));
    }

    private static int operate(int left, String operator, int right) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
