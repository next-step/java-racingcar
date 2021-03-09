package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameRound;
import racingcar.service.CarService;
import racingcar.view.InputView;

import java.util.List;

public enum RacingGameController {

    INSTANCE;

    private final CarService carService = CarService.INSTANCE;
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
}
