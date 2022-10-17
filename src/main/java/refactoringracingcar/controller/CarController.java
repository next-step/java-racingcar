package refactoringracingcar.controller;

import refactoringracingcar.domain.Car;
import refactoringracingcar.domain.CarInformation;
import refactoringracingcar.domain.RacingCarGame;
import refactoringracingcar.view.InputView;
import refactoringracingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    private CarInformation carInformation = new CarInformation();

    public void startGame() {
        String carName = InputView.enterCarName();
        int gameNumber = InputView.enterGameNumber();

        String[] carNames = carInformation.splitCarNames(carName);

        EnterCarInformation(carNames, gameNumber);
    }

    private void EnterCarInformation(String[] carNames, int gameNumber) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(carInformation.resetCarStatus(carName));
        }

        ProgressRacingCarGame(cars, gameNumber);
    }

    private void ProgressRacingCarGame(List<Car> cars, int gameNumber) {
        ResultView resultView = new ResultView();
        RacingCarGame racingCarGame = new RacingCarGame(cars, gameNumber);
        for (int i = 0; i < gameNumber; i++) {
            racingCarGame.raceCarGame();
            resultView.printGameStatus();
        }
        resultView.printWinner();
    }

}
