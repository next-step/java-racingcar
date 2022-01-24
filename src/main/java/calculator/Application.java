package calculator;

import calculator.service.Calculator;
import calculator.ui.ExpressionInput;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> formula = ExpressionInput.getExpression();
        double result = Calculator.run(formula);
        System.out.println(result);
    }
}
