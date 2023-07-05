package stringcalculator;

import java.util.Arrays;

public class StringExpression {

    public static final String INVALID_EXCEPTION_MESSAGE = "유효하지 않은 값입니다";

    private final String[] values;

    public StringExpression(String expression, String delimiter) {
        this.values = validateInputText(expression, delimiter);
    }

    private String[] parse(String expression, String delimiter) {
        return expression.split(delimiter);
    }

    private void validateNumber(String string) {
        if (!string.matches("^[0-9]*$")) {
            throw new RuntimeException(INVALID_EXCEPTION_MESSAGE);
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
        return Arrays.stream(values)
                .mapToInt(s -> stringToInt(s))
                .sum();
    }
}
