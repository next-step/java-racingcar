package calculator.element.operand;

import calculator.element.Element;

public class Operand implements Element {
    private final Integer operand;

    public Operand(int operand) {
        this.operand = operand;
    }

    public Integer getValue() {
        return operand;
    }
}
