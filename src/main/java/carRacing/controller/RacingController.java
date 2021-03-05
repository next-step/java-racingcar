package carRacing.controller;

import carRacing.model.Car;
import carRacing.model.CarRacingInformation;
import carRacing.view.InputView;
import carRacing.view.ResultView;

import java.util.ArrayList;

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
        CarRacingInformation carRacingInformation
                = new CarRacingInformation(numberOfCar,carRacingCount);
        drawLiterallyExecutionResult();

        playGame(carRacingInformation);
    }

    private void playGame(CarRacingInformation carRacingInformation) {
        while(carRacingInformation.checkCarRacingCount()) {
            carRacingInformation.decideMovable();
            drawExecutionResult(carRacingInformation.getCarList());
            System.out.print("\n");
            carRacingInformation.minusCarRacingCount();
        }
    }

    private void drawExecutionResult(ArrayList<Car> carList) {
        for(Car car : carList) {
            resultView.printExecutionResult(car.getPoisition());
        }
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
