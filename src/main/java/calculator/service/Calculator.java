package calculator.service;

import calculator.domain.Formula;
import calculator.domain.Operation;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private Calculator() {
    }

    public static double run(Formula formulaInput) {
        List<String> formula = formulaInput.getFormula();
        Stack<String> formulaCalculator = new Stack<>();

        for (int i = formula.size() - 1; i >= 0; i--) {
            formulaCalculator.push(formula.get(i));
        }

        while (formulaCalculator.size() > 1) {
            double prev = Double.parseDouble(formulaCalculator.pop());
            Operation operator = Operation.from(formulaCalculator.pop())
                .orElseThrow(() -> new IllegalArgumentException("연산자 형식 오류"));
            double next = Double.parseDouble(formulaCalculator.pop());

            double result = operator.apply(prev, next);

            formulaCalculator.push(String.valueOf(result));
        }

        return Double.parseDouble(formulaCalculator.pop());
    }
}
