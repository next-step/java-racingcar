package calculator;

public class StringCalculator {
    private static final String DELIMITER = " ";
    private static final int FIRST_INDEX = 0;

    private StringCalculator() {}
    public static StringCalculator of() {
        return new StringCalculator();
    }

    public int calculate(String expression) {
        String[] values = expression.split(DELIMITER);

        Operand result = Operand.of(values[FIRST_INDEX]);
        for(int i = 1; i < values.length; i += 2) {
            Operator operator = Operator.findOperator(values[i]);
            Operand operand = Operand.of(values[i + 1]);
            result = operator.operate(result, operand);
        }

        return result.getValue();
    }
}
