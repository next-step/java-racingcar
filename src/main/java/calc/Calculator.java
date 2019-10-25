package calc;

import calc.operations.Operators;

public class Calculator {
    private double result;

    public Calculator(String input) {
        this.result = calculate(new InputChecker(input).getFormula());
    }

    private double calculate(String[] formula) {
        double result = Double.parseDouble(formula[0]);
        for (int i = 1; i < formula.length; i += 2) {
            result = Operators.getOperation(formula[i])
                              .calculate(result, Double.parseDouble(formula[i+1]));
        }
        return result;
    }

    public double getResult() {
        return result;
    }
}
