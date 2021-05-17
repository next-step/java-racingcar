package calculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Calculator {

    public int calculate(String operation) {
        checkOperation(operation);

        Queue<String> tokens = new ArrayDeque<>(Arrays.asList(operation.split(" ")));

        int accumulator = Integer.parseInt(tokens.remove());

        while (!tokens.isEmpty()) {
            Operator operator = Operator.getOperator(tokens.remove());
            int rightHandSide = Integer.parseInt(tokens.remove());

            accumulator = operator.calculation.apply(accumulator, rightHandSide);
        }

        return accumulator;
    }

    void checkOperation(String operation) {
        if (operation == null || operation.isEmpty()) {
            throw new IllegalArgumentException("Operation is empty");
        }
    }
}
