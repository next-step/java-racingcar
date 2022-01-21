package calculator.service;

import calculator.domain.Formula;
import calculator.util.Operation;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private Calculator() {
    }

    public static double run(Formula formulaInput) {
        List<String> formulaList = formulaInput.getFormula();
        Stack<String> formula = new Stack<>();

        for (int i = formulaList.size() - 1; i >= 0; i--) {
            formula.push(formulaList.get(i));
        }

        while (formula.size() > 1) {
            double prev = Double.parseDouble(formula.pop());
            Operation operator = Operation.from(formula.pop())
                .orElseThrow(() -> new IllegalArgumentException("연산자 형식 오류"));
            double next = Double.parseDouble(formula.pop());

            double result = operator.apply(prev, next);

            formula.push(String.valueOf(result));
        }

        return Double.parseDouble(formula.pop());
    }
}
