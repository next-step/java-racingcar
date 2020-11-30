package lotto.stringsumcalculator.controller;

import lotto.stringsumcalculator.model.Calculator;
import lotto.stringsumcalculator.view.InputView;
import lotto.stringsumcalculator.view.ResultView;

public class MainController {

    public static void main(String[] args) {
        calculate();
    }

    public static void calculate(){
        String string = InputView.inPutString();
        int result = Calculator.calculate(string);

        ResultView.viewResult(result);
    }
}
