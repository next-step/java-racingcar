package stringcalculator.console;

/**
 * 계산에 사용할 전체 수식
 */
public class InputExpression {

    private String expression;

    public InputExpression(String expression) {
        validateInfixExpression(expression);
        this.expression = expression;
    }

    private static void validateInfixExpression(String infixExpression) {
        if (isEmpty(infixExpression)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEmpty(String infixExpression) {
        return infixExpression == null || infixExpression.isEmpty();
    }

    public String getExpression() {
        return expression;
    }
}
