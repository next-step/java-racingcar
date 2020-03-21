package calculator.operator;

public class MultiplyOperator extends Operator {

    @Override
    public double calculate(double operand1, double operand2) {
        double result = operand1 * operand2;
        return Math.round(result * 100) / 100.0;
    }
}
