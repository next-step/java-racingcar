package Calculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Calculator {

    public int calculate(String str) {

        Queue<String> tokens = new ArrayDeque<>(Arrays.asList(str.split(" ")));

        int accumulator = Integer.parseInt(tokens.remove());
        while (!tokens.isEmpty()) {
            Operator operator = Operator.getOperator(tokens.remove());
            int token = Integer.parseInt(tokens.remove());
            accumulator = operator.calculation.apply(accumulator, token);
        }

        return accumulator;
    }

}
