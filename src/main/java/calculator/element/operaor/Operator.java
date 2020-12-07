package calculator.element.operaor;

import calculator.element.Element;
import calculator.element.operand.Operand;

public interface Operator extends Element {
    Operand operate(Operand operandA, Operand operandB);
}
