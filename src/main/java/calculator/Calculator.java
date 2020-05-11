package calculator;


import calculator.exception.ErrorMessage;
import calculator.operation.ArithmeticOperationStrategy;
import calculator.operation.OperationStrategy;
import calculator.util.StringUtil;

public class Calculator {

    private static final String DELIMITER = " ";

    public static Calculator of() {
        return new Calculator();
    }

    public Integer run(final String input) {
        if (StringUtil.isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
        String[] values = input.split(DELIMITER);
        try {
            return calculate(values);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SUPPORTED_FORMAT);
        }
    }

    private int calculate(final String[] values) {
        int operandA = StringUtil.toInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            OperationStrategy operator = ArithmeticOperationStrategy.of(values[i]);
            int operandB = StringUtil.toInt(values[i + 1]);

            operandA = operator.operate(operandA, operandB);
        }
        return operandA;
    }
}
