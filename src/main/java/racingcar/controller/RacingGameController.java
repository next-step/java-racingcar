package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameRound;
import racingcar.service.CarService;
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

    public void createCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            carService.addCar(new Car());
        }

        cars = carService.findCars();
    }

    public void createGameRound(int numberOfAttempts) {
        gameRound = new GameRound(numberOfAttempts);
    }

    public void raceEachRound() {
        cars.forEach(car -> car.move(random.nextInt(MAX_INCLUSIVE)));
    }

    public void printGameResult() {
        ResultView.INSTANCE.printResultStatement();

        for (int i = 0; i < gameRound.getRound(); i++) {
            raceEachRound();
            ResultView.INSTANCE.printEachRoundResult(carService.findMovementRangeOfCars());
        }
    }
}
