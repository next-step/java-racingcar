package calculator;

import calculator.domain.Calculator;
import calculator.ui.ExpressionInput;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> expression = ExpressionInput.getExpression();
        double result = Calculator.run(expression);
        System.out.println(result);
    }
}
