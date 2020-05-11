package domain;

import util.Splitter;

import java.util.List;

public class Calculator {
    private static final int INITIAL_INPUT_INDEX = 0;

    private Calculator() {
    }

    public static Operand calculate(String equation) {
        List<String> equations = Splitter.split(equation);
        Operand result = new Operand(equations.get(INITIAL_INPUT_INDEX));

        for (int operationIndex = 1; operationIndex < equations.size() - 1; operationIndex += 2) {
            Operation operation = Operation.findByType(equations.get(operationIndex));
            Operand operand = new Operand(equations.get(operationIndex + 1));

            result = operation.operate(result, operand);
        }

        return result;
    }
}
