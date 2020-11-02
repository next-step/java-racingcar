package step2;

public class StringCalculator {

    private StringCalculator() {
    }

    public static Integer execute(String expression) {
        validateInputExpression(expression);
        return calculate(getValidTokens(expression));
    }

    private static void validateInputExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("input is null");
        }
    }

    private static String[] getValidTokens(String expression) {
        String[] tokens = ExpressionTokenizer.getTokens(expression);
        ExpressionTokenizer.validate(tokens);
        return tokens;
    }

    private static Integer calculate(String[] tokens) {
        Integer result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            result = Operator.fromSymbol(tokens[i]).operate(result, Integer.parseInt(tokens[i + 1]));
        }
        return result;
    }
}
