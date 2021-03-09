package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameRound;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class RacingGameController {

    private final CarService carService;
    private final Random random = new Random();
    private final int MAX_INCLUSIVE = 10;
    private List<Car> cars;
    private GameRound gameRound;

    public RacingGameController(CarService carService) {
        this.carService = carService;
    }

    public void run() {
        createCars();
        createGameRound();
        printGameResult();
    }

    private void createCars() {
        int numberOfCars = InputView.INSTANCE.InputNumberOfCars();

        for (int i = 0; i < numberOfCars; i++) {
            carService.addCar(new Car());
        }

        cars = carService.findCars();
    }

    private void createGameRound() {
        int numberOfAttempts = InputView.INSTANCE.InputNumberOfAttempts();
        gameRound = new GameRound(numberOfAttempts);
    }

    private void raceEachRound() {
        cars.forEach(car -> car.move(random.nextInt(MAX_INCLUSIVE)));
    }

    private void printGameResult() {
        ResultView.INSTANCE.printResultStatement();

        for (int i = 0; i < gameRound.getRound(); i++) {
            raceEachRound();
            ResultView.INSTANCE.printEachRoundResult(carService.findMovementRangeOfCars());
        }
    }
}
