package calculator.service;

import calculator.util.Operation;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private Calculator() {
    }

    public static double doCalculate(List<String> formula) {
        Stack<String> formulaStack = new Stack<>();
        for (int i = formula.size() - 1; i >= 0; i--) {
            formulaStack.push(formula.get(i));
        }
        while (formulaStack.size() > 1) {
            double prev = Double.parseDouble(formulaStack.pop());
            Operation operator = Operation.fromString(formulaStack.pop());
            double next = Double.parseDouble(formulaStack.pop());
            double result = operator.apply(prev, next);
            formulaStack.push(String.valueOf(result));
        }

        return Double.parseDouble(formulaStack.pop());
    }
}
