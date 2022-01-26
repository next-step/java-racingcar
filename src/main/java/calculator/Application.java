package calculator;

import calculator.domain.Formula;
import calculator.service.Calculator;
import calculator.view.FormulaInput;

public class Application {

    public static void main(String[] args) {
        Formula formula = FormulaInput.getFormula();
        double result = Calculator.run(formula);
        System.out.println(result);
    }
}
