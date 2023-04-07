package step2;

public class StringAddCalculator {

    private static final int INVALID_RETURN = 0;

    public static Integer splitAndSum(String input) {
        if (ExpressionValidator.isInvalidExpression(input))
            return INVALID_RETURN;
        Expression expression = ExpressionParser.parse(input);
        PositiveNumbers numbers = new PositiveNumbers(expression);
        return numbers.sum();
    }
}
