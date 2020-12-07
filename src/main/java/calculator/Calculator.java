package calculator;

import calculator.element.Element;
import calculator.element.operand.Operand;
import calculator.element.operaor.*;
import calculator.parser.InputParser;
import calculator.parser.ElementDeque;

public class Calculator {

    static int equality(String input) {
        ElementDeque elementDeque = InputParser.parseResult(input);
        return operateMultiple(elementDeque);
    }

    private static int operateMultiple(ElementDeque elementDeque) {
        while(! elementDeque.isQuitCalculate()) {
            Operand operandA = elementDeque.popOperand();
            Operator operator = elementDeque.popOperator();
            Operand operandB = elementDeque.popOperand();
            Element result = operator.operate(operandA, operandB);
            elementDeque.addResult(result);
        }

        return elementDeque.popOperand().getValue();
    }
}
