package calculator.parser;

import calculator.element.Element;
import calculator.element.operand.Operand;
import calculator.element.operaor.Operator;
import calculator.element.operaor.OperatorFactory;

import java.util.*;

public class ElementDeque {
    Deque<Element> elements = new ArrayDeque<>();

    public ElementDeque(String[] splitInput) {
        for (String s : splitInput) {
            if(OperatorFactory.isOperator(s)) {
                Operator operator = OperatorFactory.getOperator(s);
                elements.addLast(operator);
                continue;
            }

            int intValue = Integer.parseInt(s);
            elements.addLast(new Operand(intValue));
        }
    }

    public void addResult(Element operand) {
        elements.addFirst(operand);
    }

    public Element popElement() {
        return elements.pop();
    }

    public boolean isQuitCalculate() {
        return elements.size() <= 1;
    }

}
