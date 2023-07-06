package stringcalculator;

import java.util.Arrays;

public class Expression {

    private final String[] elements;

    public Expression(String expression, String delimiter) {
        this.elements = validateInputText(expression, delimiter);
    }

    private String[] validateInputText(String expression, String delimiter) {
        String[] elements = parse(expression, delimiter);
        for (String element : elements) {
            validateNumber(element);
        }

        return elements;
    }

    private String[] parse(String expression, String delimiter) {
        return expression.split(delimiter);
    }

    private void validateNumber(String element) {
        if (!element.matches("^[0-9]*$")) {
            throw new RuntimeException("유효하지 않은 값입니다");
        }
    }

    public int sumString() {
        return Arrays.stream(elements)
                .mapToInt(element -> stringToInt(element))
                .sum();
    }

    private int stringToInt(String element) {
        if (element.isBlank()) {
            return 0;
        }

        return Integer.parseInt(element);
    }
}
