package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorMain {
    public static void main(String[] args) {
        String result = run(InputView.inputExpression());
        OutputView.showResult(result);
    }

    public static String run(String inputExpression) {
        Expression expression = new Expression(inputExpression);
        Calculator calculator = new Calculator(expression);
        return calculator.calculate();
    }
}
