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

        enterCarInformation(carNames, gameNumber);
    }

    private void enterCarInformation(String[] carNames, int gameNumber) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(carInformation.resetCarStatus(carName));
        }

        progressRacingCarGame(cars, gameNumber);
    }

    private void progressRacingCarGame(List<Car> cars, int gameNumber) {
        RacingCarGame racingCarGame = new RacingCarGame(cars);
        for (int i = 0; i < gameNumber; i++) {
            racingCarGame.raceCarGame();
            ResultView.printGameStatus(cars);
        }
        ResultView.printWinner(cars);
    }

}
