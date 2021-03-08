package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRacingInformation;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;

public class RacingGameController {
    private InputView inputView;
    private ResultView resultView;

    public RacingGameController() {
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
