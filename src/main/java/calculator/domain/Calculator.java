package calculator.domain;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private static final int LAST_INDEX = 0;
    private static final int SIZE_ONE = 1;
    private Calculator() {
    }

    public static double calculate(List<String> formula) {
        Stack<String> formulaStack = new Stack<>();
        for (int i = formula.size() - SIZE_ONE; i >= LAST_INDEX; i--) {
            formulaStack.push(formula.get(i));
        }
        while (formulaStack.size() > SIZE_ONE) {
            double prev = Double.parseDouble(formulaStack.pop());
            Operation operator = Operation.fromString(formulaStack.pop());
            double next = Double.parseDouble(formulaStack.pop());
            double result = operator.apply(prev, next);
            formulaStack.push(String.valueOf(result));
        }

        return Double.parseDouble(formulaStack.pop());
    }
}
