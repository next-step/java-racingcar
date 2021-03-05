package carRacing.controller;

import carRacing.model.Car;
import carRacing.model.CarRacingInformation;
import carRacing.view.InputView;
import carRacing.view.ResultView;

public class RacingController {
    private InputView inputView;
    private ResultView resultView;
    private CarRacingInformation carRacingInformation;

    public RacingController() {
        inputView = new InputView();
        resultView = new ResultView();
    }
    public void runGame() {
        int numberOfCar = drawNumberOfCarAndReturn();
        int carRacingCount = drawCarCountAndReturn();
        carRacingInformation = new CarRacingInformation(numberOfCar,carRacingCount);
        drawLiterallyExecutionResult();
        playGame();

    }

    private void playGame() {
        while(carRacingInformation.checkCarRacingCount()) {
            carRacingInformation.decideMovable();
            for(Car car : carRacingInformation.getCarList()) {
                drawExecutionResult(car.getPoisition());
            }
            System.out.print("\n");
            carRacingInformation.minusCarRacingCount();
        }
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
