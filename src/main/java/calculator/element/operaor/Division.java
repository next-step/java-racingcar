package calculator.element.operaor;

import calculator.element.operand.Operand;

public class Division implements Operator {
    @Override
    public Operand operate(Operand operandA, Operand operandB) {
        if(operandB.getValue() == 0) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }
        return new Operand(operandA.getValue() / operandB.getValue());
    }
}
