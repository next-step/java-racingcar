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
        Stack<Double> operandCalculator = new Stack<>();
        Stack<Operation> operationCalculator = new Stack<>();

        initOperandCalculator(formula, operandCalculator);
        initOperationCalculator(formula, operationCalculator);

        while (operandCalculator.size() > 1) {
            Double prev = operandCalculator.pop();
            Operation operator = operationCalculator.pop();
            Double next = operandCalculator.pop();

            double result = operator.apply(prev, next);

            operandCalculator.push(result);
        }

        return operandCalculator.pop();
    }

    private static Stack<Double> initOperandCalculator(List<String> formula,
        Stack<Double> operandCalculator) {
        for (int i = formula.size() - 1; i >= 0; i -= 2) {
            operandCalculator.push(Double.parseDouble(formula.get(i)));
        }
        return operandCalculator;
    }

    private static Stack<Operation> initOperationCalculator(List<String> formula,
        Stack<Operation> operationCalculator) {
        for (int i = formula.size() - 2; i >= 1; i -= 2) {
            Operation operation = Operation.from(formula.get(i));
            operationCalculator.push(operation);
        }
        return operationCalculator;
    }

    public static int sub(int prev, int next) {
        return prev - next;
    }

    public static int multiply(int prev, int next) {
        return prev * next;
    }
}
