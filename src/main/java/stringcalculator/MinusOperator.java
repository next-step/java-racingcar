package stringcalculator;

public class MinusOperator implements Operator {

    @Override
    public int calculate(int operand, int secondOperand) {
        return operand - secondOperand;
    }
}
