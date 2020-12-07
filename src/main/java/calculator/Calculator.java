package calculator;

import calculator.operaor.*;
import calculator.parser.InputParser;
import calculator.parser.InputDeque;

public class Calculator {

    public static final String SPLIT_SPACE_CHAR = " ";

    static Integer equality(String input) {
        InputDeque inputDeque = InputParser.parseResult(input);

        int operandA = Integer.parseInt(inputDeque.popInputItem());
        Operator operator = OperatorFactory.getOperator(inputDeque.popInputItem());
        int operandB = Integer.parseInt(inputDeque.popInputItem());

        return operator.operate(operandA, operandB);
    }

    private static String[] parseInput(String input) {
        return input.split(SPLIT_SPACE_CHAR);
    }
}
