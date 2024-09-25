package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView("//_\n1_2_3");
        inputView.printInput();

        StringAddCalculator addCalculator = new StringAddCalculator(inputView.input());

        new OutputView(addCalculator.sum())
                .printResult();
    }
}
