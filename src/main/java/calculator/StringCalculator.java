package calculator;

public class StringCalculator {

    private static final String SPLIT_TOKEN = " ";

    public static int calculate(String text) {
        return calculateExpression(splitExpression(text));
    }

    public static int parseToNumeric(String value) {
        return Integer.parseInt(value);
    }

    public static String[] splitExpression(String text) {
        return text.split(SPLIT_TOKEN);
    }

    public static int calculateExpression(String[] expression) {
        int result = parseToNumeric(expression[0]);

        for (int i = 1; i < expression.length; i += 2) {
            int operand = parseToNumeric(expression[i + 1]);
            String operator = expression[i];

            result = calculateEach(result, operand, operator);
        }

        return result;
    }

    public static int calculateEach(int op1, int op2, String operator) {
        if ("+".equals(operator)) {
            return op1 + op2;
        } else if ("-".equals(operator)) {
            return op1 - op2;
        } else if ("*".equals(operator)) {
            return op1 * op2;
        } else if ("/".equals(operator)) {
            return op1 / op2;
        }

        throw new IllegalArgumentException("Not support operator.");
    }

}
