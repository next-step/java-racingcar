package stringcalculator;

public class DivideOperator implements Operator {

    @Override
    public int calculate(int operand, int secondOperand) {
        return operand / secondOperand;
    }
}
