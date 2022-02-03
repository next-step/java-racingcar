package calculator.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator {

    private static final int SIZE_ONE = 1;
    private List<String> formula;

    public Calculator(List<String> formula) {
        this.formula = formula;
    }

    public double calculate() {
        LinkedList<String> formulaStack = new LinkedList<>(formula);
        while (formulaStack.size() > SIZE_ONE) {
            double prev = Double.parseDouble(formulaStack.pollFirst());
            Operation operator = Operation.fromString(formulaStack.pollFirst());
            double next = Double.parseDouble(Objects.requireNonNull(formulaStack.pollFirst()));
            double result = operator.apply(prev, next);
            formulaStack.push(String.valueOf(result));
        }

        return Double.parseDouble(formulaStack.pop());
    }
}
