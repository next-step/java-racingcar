package calculator.service;

import calculator.util.Operation;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private Calculator() {
    }

    public static double run(List<String> expression) {
        Stack<String> symbols = new Stack<>();

        for (int i = expression.size() - 1; i >= 0; i--) {
            symbols.push(expression.get(i));
        }

        while (symbols.size() > 1) {
            double prev = Double.parseDouble(symbols.pop());
            Operation operator = Operation.fromString(symbols.pop()).get();
            double next = Double.parseDouble(symbols.pop());

            double result = operator.apply(prev, next);

            symbols.push(String.valueOf(result));
        }

        return Double.parseDouble(symbols.pop());
    }
}
