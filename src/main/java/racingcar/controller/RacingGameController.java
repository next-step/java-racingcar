package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRacingInformation;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;

public class RacingGameController {

    private InputView inputView;
    private ResultView resultView;
    private CarRacingInformation carRacingInformation;


    public RacingGameController() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void runGame() {
        int numberOfCar = drawNumberOfCarAndReturn();
        int carRacingCount = drawCarCountAndReturn();
        carRacingInformation
                = new CarRacingInformation(numberOfCar,carRacingCount);
        drawLiterallyExecutionResult();
        playGame();
    }

    private void playGame() {
        while (carRacingInformation.checkCarRacingCount()) {
            ArrayList<Car> movedCarList = carRacingInformation.decideMovable();
            drawExecutionResult(movedCarList);
            System.out.print("\n");
            carRacingInformation.minusCarRacingCount();
        }
    }


    private void drawExecutionResult(ArrayList<Car> carList) {
        for (Car car : carList) {
            resultView.printExecutionResult(car.getPoisition());
        }
    }

    private void drawLiterallyExecutionResult() {
        resultView.printLiterallyExecutionResult();
    }

    private int drawCarCountAndReturn() {
        return inputView.inputCarCount();
    }

    private int drawNumberOfCarAndReturn() {
        return inputView.inputNumberOfCar();
    }

}
