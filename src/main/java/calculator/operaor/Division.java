package calculator.operaor;

public class Division implements Operator {
    @Override
    public int operate(int operandA, int operandB) {
        return operandA / operandB;
    }
}
