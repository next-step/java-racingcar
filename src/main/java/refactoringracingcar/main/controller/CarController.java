package refactoringracingcar.main.controller;

import refactoringracingcar.domain.Car;
import refactoringracingcar.domain.CarInformation;
import refactoringracingcar.domain.RacingCarGame;
import refactoringracingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    private CarInformation carInformation = new CarInformation();

    public String startGame() {
        String carName = InputView.enterCarName();
        int gameNumber = InputView.enterGameNumber();

        String[] carNames = carInformation.splitCarNames(carName);

        return EnterCarInformation(carNames, gameNumber);
    }

    public String EnterCarInformation(String[] carNames, int gameNumber) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(carInformation.resetCarStatus(carName));
        }

        return ProgressRacingCarGame(cars, gameNumber);
    }

    public String ProgressRacingCarGame(List<Car> cars, int gameNumber) {
        return new RacingCarGame(cars, gameNumber).RunGame();
    }

}
