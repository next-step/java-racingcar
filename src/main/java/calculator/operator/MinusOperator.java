package calculator.operator;

public class MinusOperator extends Operator {

    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 - operand2;
    }
}
