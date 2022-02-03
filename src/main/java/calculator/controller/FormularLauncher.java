package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.FormulaInput;
import calculator.view.FormulaOutput;
import java.util.List;

public class FormularLauncher {

    public void start() {
        FormulaOutput.printRequestFormula();
        List<String> formula = FormulaInput.readFormula();
        Calculator calculator = new Calculator(formula);
        double result = calculator.calculate();
        FormulaOutput.printFormulaResult(result);
    }
}
