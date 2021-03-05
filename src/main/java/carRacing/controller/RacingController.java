package carRacing.controller;

import carRacing.view.InputView;
import carRacing.view.ResultView;

public class RacingController {
    private InputView inputView;
    private ResultView resultView;

    public RacingController() {
        inputView = new InputView();
        resultView = new ResultView();
    }
    public void runGame() {
        int numberOfCar = drawNumberOfCarAndReturn();
        int carRacingCount = drawCarCountAndReturn();

        
    }

    private void drawExecutionResult(int position) {
        resultView.printExecutionResult(position);
    }

    private void drawLiterallyExecutionResult() {
        resultView.printLiterallyExecutionResult();
    }

    private int drawCarCountAndReturn() {
        resultView.printCarCountQuestion();
        return inputView.inputNumber();
    }

    private int drawNumberOfCarAndReturn() {
        resultView.printNumberOfCarQuestion();
        return inputView.inputNumber();
    }
}
