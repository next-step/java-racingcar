package calculator;

import calculator.element.Element;
import calculator.element.operand.Operand;
import calculator.element.operaor.*;
import calculator.parser.InputParser;
import calculator.parser.ElementDeque;

public class Calculator {

    static Integer equality(String input) {
        ElementDeque elementDeque = InputParser.parseResult(input);

        while(! elementDeque.isQuitCalculate()) {
            Operand operandA = (Operand) elementDeque.popElement();
            Operator operator = (Operator) elementDeque.popElement();
            Operand operandB = (Operand) elementDeque.popElement();
            Element result = operator.operate(operandA, operandB);
            elementDeque.addResult(result);
        }

        Operand operand = (Operand) elementDeque.popElement();
        return operand.getValue();
    }
}
