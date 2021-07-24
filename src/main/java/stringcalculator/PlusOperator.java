package stringcalculator;

public class PlusOperator implements Operator {

    @Override
    public int calculate(int operand, int secondOperand) {
        return operand + secondOperand;
    }
}
