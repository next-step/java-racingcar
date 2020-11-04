package stringcalculator;

public class Expression {

    private final String[] expressionArray;

    public Expression(String input) {
        validate(input);
        expressionArray = input.split(" ");
    }

    private void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 수식입니다.");
        }
    }

    public int getInteger(int index) {
        return Integer.parseInt(expressionArray[index]);
    }

    public int getLength() {
        return expressionArray.length;
    }

    public String get(int index) {
        return expressionArray[index];
    }
}
