package calculator.operator;

public class PlusOperator extends Operator {

    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 + operand2;
    }
}
