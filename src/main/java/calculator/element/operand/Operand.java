package calculator.element.operand;

import calculator.element.Element;

public class Operand implements Element {
    private final int operand;

    public Operand(int operand) {
        this.operand = operand;
    }

    public int getValue() {
        return operand;
    }
}
