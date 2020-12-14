package step2;

import step2.domain.Calculator;
import step2.view.InputView;
import step2.view.OutputView;

public class Main {

    public static void main(String[] args) {
        String expression = InputView.readExpression();

        OutputView.printResult(Calculator.calculate(expression));
    }
}
