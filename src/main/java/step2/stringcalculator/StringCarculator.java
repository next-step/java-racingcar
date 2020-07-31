package step2.stringcalculator;

import java.util.Arrays;
import java.util.List;

public class StringCarculator {

    public int getStringCalculator(String inputExpression) {
        CommonException.inputExpressionInValidException(inputExpression);

        List<String> expressions = Arrays.asList(inputExpression.split(CommonConstant.DELIMITER));
        int resultValue = Integer.parseInt(expressions.get(0));

        for (int i = 1; i < expressions.size(); i += 2) {
            String operator = expressions.get(i);
            int number = Integer.parseInt(expressions.get(i + 1));
            resultValue = StringCarculator.calculate(operator, resultValue, number);
        }
        return resultValue;
    }


    public static int calculate(String operator, int firstNumber, int secondNumber) {
        if (operator.equals(CommonConstant.PLUS_SIGN)) {
            return Operator.PLUS.getSolve(firstNumber, secondNumber);
        }
        if (operator.equals(CommonConstant.MINUS_SIGN)) {
            return Operator.MINUS.getSolve(firstNumber, secondNumber);
        }
        if (operator.equals(CommonConstant.MULTIPLICATION_SIGN)) {
            return Operator.MULTIPLY_BY.getSolve(firstNumber, secondNumber);
        }
        if (operator.equals(CommonConstant.DIVISION_SIGN)) {
            return Operator.DIVIDED_BY.getSolve(firstNumber, secondNumber);
        }
        throw new IllegalArgumentException(operator + CommonConstant.INVALID_OPERATOR);
    }

}
