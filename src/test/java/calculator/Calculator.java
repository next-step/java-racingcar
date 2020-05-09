package calculator;


import java.util.Arrays;
import java.util.List;

public class Calculator {

    public long calculate(String input) {
        if (input == null || input.trim().length() == 0) {
            throw new IllegalArgumentException("empty string");
        }

        List<String> supportedOperator = Arrays.asList("+", "-", "*", "/");
        input = input.trim();
        String[] elements = input.split(" ");
        for (String element : elements) {
            if (isNumber(element)) {
                continue;
            }

            if (!supportedOperator.contains(element)) {
                throw new IllegalArgumentException("not supported operator");
            }
        }

        return 0;
    }

    private boolean isNumber(String element) {
        try {
            Double.parseDouble(element);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
