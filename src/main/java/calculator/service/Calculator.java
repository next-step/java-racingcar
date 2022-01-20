package calculator.service;

import calculator.domain.Formula;
import calculator.util.Operation;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private Calculator() {
    }

    public static double run(Formula formula) {
        List<String> formulalist = formula.getFormula();
        Stack<String> formulaStack = new Stack<>();

        for (int i = formulalist.size() - 1; i >= 0; i--) {
            formulaStack.push(formulalist.get(i));
        }

        while (formulaStack.size() > 1) {
            double prev = Double.parseDouble(formulaStack.pop());
            Operation operator = Operation.fromString(formulaStack.pop())
                .orElseThrow(() -> new IllegalArgumentException("연산자 형식 오류"));
            double next = Double.parseDouble(formulaStack.pop());

            double result = operator.apply(prev, next);

            formulaStack.push(String.valueOf(result));
        }

        return Double.parseDouble(formulaStack.pop());
    }
}
