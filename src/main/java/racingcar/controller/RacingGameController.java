package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameRound;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public enum RacingGameController {

    INSTANCE;

    private final CarService carService = CarService.INSTANCE;
    private final Random random = new Random();
    private final int MAX_INCLUSIVE = 10;
    private List<Car> cars;
    private GameRound gameRound;

    public void run() {
        createCars();
        createGameRound();
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
}
