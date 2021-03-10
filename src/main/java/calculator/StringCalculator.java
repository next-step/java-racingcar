package calculator;

import calculator.enums.Operator;

import java.util.Queue;

public class StringCalculator {

    private Queue<Integer> operands;
    private Queue<Operator> operators;

    public int calculate(Expression expression) {
        operands = expression.getOperands();
        operators = expression.getOperators();
        int sum = operands.poll();

        for (Operator operator : operators) {
            int result = operator.calculate(sum, operands.poll());
            sum = result;
        }

        return sum;
    }
}