package stringcalculator;

public class SimpleExpression {
    private final String[] expressionArray;
    private final int length;

    public SimpleExpression(String expression) {
        validateExpr(expression);
        expressionArray = expression.split(" ");
        length = expressionArray.length;
    }

    public String get(int index) {
        validateExpr(expressionArray[index]);
        return expressionArray[index];
    }

    public int getInteger(int index) {
        try {
            validateExpr(expressionArray[index]);
            return Integer.valueOf(expressionArray[index]);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }

    public int getLength() {
        return length;
    }

    private void validateExpr(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null이 들어올 수 없습니다.");
        }
        if ("".equals(str)) {
            throw new IllegalArgumentException("빈 문자열이 들어올 수 없습니다.");
        }
    }
}
