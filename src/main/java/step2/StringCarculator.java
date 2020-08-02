package step2;

import java.util.Arrays;
import java.util.List;

public class StringCarculator {

    public int calculate(String inputExpression) {
        inputExpressionInValidException(inputExpression);

        List<String> expressions = Arrays.asList(inputExpression.split(CommonConstant.DELIMITER));
        int resultValue = Integer.parseInt(expressions.get(0));

        for (int i = 1; i < expressions.size(); i += 2) {
            String operator = expressions.get(i);
            int number = Integer.parseInt(expressions.get(i + 1));
            resultValue = Operator.operate(operator, resultValue, number);
        }
        return resultValue;
    }

    public static void inputExpressionInValidException(String inputExpression) {
        if (inputExpression == null || inputExpression.trim().isEmpty()) {
            throw new IllegalArgumentException(CommonConstant.INVALID_INPUT_EXPRESSION);
        }
    }

}
