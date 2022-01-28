package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.FormulaInput;
import java.util.List;

public class FormularLauncher {

    public void start() {
        List<String> formula = FormulaInput.getFormula();
        double result = Calculator.calculate(formula);
        System.out.println(result);
    }
}
