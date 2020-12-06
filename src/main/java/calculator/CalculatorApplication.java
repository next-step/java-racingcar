package calculator;

import calculator.domain.StringCalculator;
import calculator.view.CalculateInputView;
import calculator.view.CalculateOutView;

public class CalculatorApplication {
    public static void main(String[] args) {
        StringCalculator calculator =  CalculateInputView.getStringCalculator();
        int result = calculator.calculate();
        CalculateOutView.showResult(result);
    }
}
