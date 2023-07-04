package stringcalculator;

public class StringExpression {

    private final String[] stringArray;

    public StringExpression(String expression, String delimiter) {
        this.stringArray = validateInputText(expression, delimiter);
    }

    public String[] getStringArray() {
        return stringArray;
    }

    public String[] parse(String expression, String delimiter) {
        return expression.split(delimiter);
    }

    public void validateNumber(String string) {
        if (!string.matches("^[0-9]+$")) {
            throw new RuntimeException("유효하지 않은 값입니다");
        }
    }

    public String[] validateInputText(String expression, String delimiter) {
        String[] stringArray = parse(expression, delimiter);
        for (String string : stringArray) {
            validateNumber(string);
        }

        return stringArray;
    }
}
