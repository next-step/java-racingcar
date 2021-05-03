package Calculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Calculator {

    public static int calculate(String str) {

        Queue<String> tokens = new ArrayDeque<>(Arrays.asList(str.split(" ")));

        int accumulator = Integer.parseInt(tokens.remove());
        while (!tokens.isEmpty()) {
            Operator operator = Operator.getOperator(tokens.remove());
            int rhs = Integer.parseInt(tokens.remove());

            accumulator = operator.calculation.apply(accumulator, rhs);
        }

        return accumulator;
    }

}