package calculator.controller;

import calculator.domain.CalculatorService;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {
    public static void main(String[] args) {
        String inputFormula = InputView.inputString();

        CalculatorService calculatorService = new CalculatorService(inputFormula);
        calculatorService.checkSymbol();

        ResultView.showResult(calculatorService.calculateSplitedString());
    }
}
