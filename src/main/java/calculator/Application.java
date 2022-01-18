package calculator;

import calculator.domain.Calculator;
import calculator.util.InputView;
import calculator.util.ResultView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String inputExpression = InputView.getLine();
        int result = calculator.calculate(inputExpression);
        ResultView.showResult(result);
    }
}
