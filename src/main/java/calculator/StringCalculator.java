package calculator;

public class StringCalculator {
    private static final String DELIMITER = " ";
    private static final int FIRST_INDEX = 0;

    private StringCalculator() {}
    public static StringCalculator of() {
        return new StringCalculator();
    }

    public int calculate(String expression) {
        String[] values = splitExpressionByDelimiter(expression);

        Operand result = Operand.of(values[FIRST_INDEX]);
        for(int i = 1; i < values.length; i += 2) {
            Operator operator = Operator.findOperator(values[i]);
            Operand operand = Operand.of(values[i + 1]);
            result = operator.operate(result, operand);
        }

        return result.getValue();
    }

    private String[] splitExpressionByDelimiter(String expression) {
        String[] values = expression.split(DELIMITER);
        if(isInValidExpression(values)) {
            throw new IllegalArgumentException("연산자와 피연산자는 공백을 기준으로 정확하게 입력해주세요. EX) 2 + 3 * 4 / 2");
        }

        return values;
    }

    private boolean isInValidExpression(String[] values) {
        return values.length < 3 || values.length % 2 == 0;
    }
}
