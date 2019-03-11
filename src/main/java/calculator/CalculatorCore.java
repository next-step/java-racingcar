package calculator;

import static calculator.CalculatorOperator.*;

public class CalculatorCore {

    private static int result = 0;

    public static int createExpression(String[] values) {

        result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length - 1; i+=2) {
            result = calculate(values[i], values[i + 1]);
        }

        return result;
    }

    public static int calculate(String operator, String nextValue) {

        if (operator.equals(ADD.getOperator())) {
            return ADD.calculate(result, Integer.valueOf(nextValue));
        }

        if (operator.equals(SUBTRACT.getOperator())) {
            return SUBTRACT.calculate(result, Integer.valueOf(nextValue));
        }

        if (operator.equals(MULTIPLICATION.getOperator())) {
            return MULTIPLICATION.calculate(result, Integer.valueOf(nextValue));
        }

        if (operator.equals(DIVISION.getOperator())) {
            return DIVISION.calculate(result, Integer.valueOf(nextValue));
        }

        return result;
    }

}
