package stringcalculator;


import stringcalculator.business.Calculator;
import stringcalculator.presentation.InputView;
import stringcalculator.presentation.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Calculator calculator = new Calculator();

        calculator.input(inputView.getExpression());

        new ResultView(calculator.calculate());
    }
}
