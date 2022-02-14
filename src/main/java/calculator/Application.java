package calculator;

import calculator.domain.Calculator;
import calculator.util.Parser;
import calculator.view.InputView;
import calculator.view.ResultView;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        final String expression = InputView.getLine();
        final List<String> splitExpression = Parser.splitExpression(expression);
        final Calculator calculator = new Calculator(splitExpression);

        final int result = calculator.getResult();
        ResultView.printResult(result);

    }
}
