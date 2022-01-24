package calculator;

import calculator.domain.Calculator;
import calculator.ui.FormulaInput;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> formula = FormulaInput.getFormula();
        double result = Calculator.doCalculate(formula);
        System.out.println(result);
    }
}
