package calculator;

import java.util.Queue;

public class Calculator {
    private Splitter splitter;

    public Calculator(String operation) {
        splitter = new Splitter(operation);
    }

    public int calculate() {
        Queue<String> tokens = splitter.getTokens();

        int accumulator = Integer.parseInt(tokens.remove());

        while (!tokens.isEmpty()) {
            Operator operator = Operator.getOperator(tokens.remove());
            int rightHandSide = Integer.parseInt(tokens.remove());

            accumulator = operator.calculation.apply(accumulator, rightHandSide);
        }

        return accumulator;
    }
}
