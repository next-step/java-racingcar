package stringcalculator;

import java.util.Arrays;

public class StringExpression {

    private final String[] stringArray;

    public StringExpression(String expression, String delimiter) {
        this.stringArray = validateInputText(expression, delimiter);
    }

    private String[] parse(String expression, String delimiter) {
        return expression.split(delimiter);
    }

    private void validateNumber(String string) {
        if (!string.matches("^[0-9]*$")) {
            throw new RuntimeException("유효하지 않은 값입니다");
        }
    }

    private String[] validateInputText(String expression, String delimiter) {
        String[] stringArray = parse(expression, delimiter);
        for (String string : stringArray) {
            validateNumber(string);
        }

        return stringArray;
    }

    private int stringToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    public int sumString() {
        return Arrays.stream(stringArray)
                .mapToInt(s -> stringToInt(s))
                .sum();
    }
}
