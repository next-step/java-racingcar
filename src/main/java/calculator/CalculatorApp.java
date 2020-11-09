package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;

public class CalculatorApp {
    public static void main(String[] args) {
        StringCalculator stringCalculator = StringCalculator.of(InputView.inputString());
        System.out.println(stringCalculator);
    }
}
