package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int compute(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input must not null or blank");
        }

        List<String> list = new ArrayList<>(Arrays.asList(s.split(" ")));

        while (list.size() != 1) {
            int left = Integer.parseInt(list.remove(0));
            String operator = list.remove(0);
            int right = Integer.parseInt(list.remove(0));

            int result;
            switch (operator) {
                case "+":
                    result = left + right;
                    break;
                case "-":
                    result = left - right;
                    break;
                case "*":
                    result = left * right;
                    break;
                case "/":
                    result = left / right;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
            list.add(0, Integer.toString(result));
        }

        return Integer.parseInt(list.get(0));
    }
}
