package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.FormulaInput;
import java.util.List;

public class FormularLauncher {

    public void start() {
        List<String> formula = FormulaInput.getFormula();
        Calculator calculator = new Calculator(formula);
        double result = calculator.calculate();
        System.out.println(result);
    }
}
