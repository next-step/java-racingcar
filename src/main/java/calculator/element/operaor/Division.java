package calculator.element.operaor;

import calculator.element.operand.Operand;

public class Division implements Operator {
    @Override
    public Operand operate(Operand operandA, Operand operandB) {
        return new Operand(operandA.getValue() / operandB.getValue());
    }
}
