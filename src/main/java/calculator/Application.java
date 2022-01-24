package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<String> splitedInput = inputView.readLine();

        Calculator calculator = new Calculator(splitedInput);

        inputView.printResult(calculator.getResult());
    }
}
