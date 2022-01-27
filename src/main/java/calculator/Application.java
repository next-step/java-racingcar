package calculator;

import calculator.domain.Calculator;
import calculator.util.Parser;
import calculator.view.InputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        String expression = InputView.getLine();
        List<String> splitExpression = Parser.splitExpression(expression);
        Calculator calculator = new Calculator(splitExpression);
        calculator.printResult();
    }
}
