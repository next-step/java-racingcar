package calculator.parser;

import calculator.element.Element;
import calculator.element.operand.Operand;
import calculator.element.operaor.Operator;
import calculator.element.operaor.OperatorFactory;

import java.util.*;

public class ElementDeque {
    Deque<Element> elements = new ArrayDeque<>();

    public ElementDeque(String[] splitInput) {
        for (int index = 0; index < splitInput.length; index++) {
            addElement(splitInput[index], index);
        }
    }

    private void addElement(String elementStr, int index) {
        if(isOperandPosition(index)) {
            addOperand(elementStr);
        } else {
            addOperator(elementStr);
        }
    }

    private void addOperand(String elementStr) {
        int intValue = Integer.parseInt(elementStr);
        elements.addLast(new Operand(intValue));
    }

    private void addOperator(String elementStr) {
        Operator operator = OperatorFactory.getOperator(elementStr);
        elements.addLast(operator);
    }

    private boolean isOperandPosition(int index) {
        return index % 2 == 0;
    }

    public void addResult(Element operand) {
        elements.addFirst(operand);
    }

    public Operand popOperand() {
        return (Operand) elements.pop();
    }

    public Operator popOperator() {
        return (Operator) elements.pop();
    }

    public boolean isQuitCalculate() {
        return elements.size() <= 1;
    }

}
