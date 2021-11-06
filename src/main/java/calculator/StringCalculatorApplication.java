package calculator;

import calculator.domain.Operand;
import calculator.domain.StringCalculator;
import calculator.ui.StringCalculatorView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        StringCalculator calculator = StringCalculator.getInstance();
        StringCalculatorView view = StringCalculatorView.getInstance();

        String expression = view.input();
        Operand result = calculator.execute(expression);

        view.printResult(result);
    }
}
