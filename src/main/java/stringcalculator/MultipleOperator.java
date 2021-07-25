package stringcalculator;

public class MultipleOperator implements Operator {

    @Override
    public int calculate(int operand, int secondOperand) {
        return operand * secondOperand;
    }
}
