package domain;

import domain.operation.Operation;
import util.Splitter;

import java.util.List;

public class Calculator {

    private static final int INITIAL_INPUT_INDEX = 0;

    private Calculator() {
    }

    public static Operand calculate(String equation) {
        List<String> equations = Splitter.split(equation);
        Operand result = new Operand(equations.get(INITIAL_INPUT_INDEX));

        for (int operationIdx = 1; operationIdx < equations.size() - 1; operationIdx += 2) {
            Operation operation = Operation.findByType(equations.get(operationIdx));
            Operand operand = new Operand(equations.get(operationIdx + 1));

            result = operation.operate(result, operand);
        }

        return result;
    }
}
