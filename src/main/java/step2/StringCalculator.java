package step2;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int compute(String inputExpression) {
        inputExpressionInValidException(inputExpression);

        List<String> expressions = Arrays.asList(inputExpression.split(CommonConstant.DELIMITER));
        int resultValue = stringToInt(expressions.get(CommonConstant.ZERO_NUMBER));

        for (int i = CommonConstant.BASE_CALCULATION_NUMBER; i < expressions.size(); i += CommonConstant.OPERATOR_DETERMINATION_NUMBER) {
            String operator = expressions.get(i);
            int number = stringToInt(expressions.get(i + CommonConstant.BASE_CALCULATION_NUMBER));
            resultValue = calculate(operator, resultValue, number);
        }
        return resultValue;
    }

    public static int calculate(String operator, int firstNumber, int secondNumber) {
        Operator operation = Operator.of(operator);
        return operation.calculate(firstNumber, secondNumber);
    }

    public static void inputExpressionInValidException(String inputExpression) {
        if (inputExpression == null || inputExpression.trim().isEmpty()) {
            throw new IllegalArgumentException(CommonConstant.INVALID_INPUT_EXPRESSION);
        }
    }

    private int stringToInt(String value) {
        return Integer.parseInt(value);
    }

}
