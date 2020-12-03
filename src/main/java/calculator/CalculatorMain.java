package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorMain {
    public static void main(String[] args) {
        Long result = run(InputView.inputExpression());
        OutputView.showResult(result);
    }

    public static Long run(String inputExpression) {
        Expression expression = new Expression(inputExpression);
        Calculator calculator = new Calculator(expression);
        return calculator.calculate();
    }
}
