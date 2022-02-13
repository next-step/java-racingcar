package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.FormulaInput;
import calculator.view.FormulaOutput;

public class FormularLauncher {

    public void start() {
        FormulaOutput.printRequestFormula();
        Calculator calculator = new Calculator(FormulaInput.readFormula());

        double result = calculator.calculate();
        FormulaOutput.printFormulaResult(result);
    }
}
