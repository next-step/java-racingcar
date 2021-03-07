package calculator;

import calculator.enums.Operator;

import java.util.List;

public class StringCalculator {

    private List<Integer> operands;
    private List<Operator> operators;

    public int calculate(Expression expression) {
        operands = expression.getOperands();
        operators = expression.getOperators();
        int operandsIndex = 0;
        int sum = operands.get(operandsIndex++);

        for (Operator operator : operators) {
            int result = operator.calculate(sum, operands.get(operandsIndex++));
            sum = result;
        }

        return sum;
    }
}