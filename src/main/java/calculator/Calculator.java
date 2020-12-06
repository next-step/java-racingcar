package calculator;

import calculator.operaor.*;

public class Calculator {

    public static final String SPLIT_SPACE_CHAR = " ";

    static Integer equality(String input) {
        String[] splitInput = parseInput(input);

        int operandA = Integer.parseInt(splitInput[0]);
        int operandB = Integer.parseInt(splitInput[2]);
        Operator operator = OperatorFactory.getOperator(splitInput[1]);
        return operator.operate(operandA, operandB);
    }

    private static String[] parseInput(String input) {
        return input.split(SPLIT_SPACE_CHAR);
    }
}
