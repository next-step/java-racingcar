package lotto;

public class StringCalculator {

    public Integer enterExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }
        Expression expressionResolver = new Expression(expression);
        return expressionResolver.sum();
    }
}
