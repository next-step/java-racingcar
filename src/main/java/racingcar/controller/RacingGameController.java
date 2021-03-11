package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameRound;
import racingcar.service.CarService;
import racingcar.service.GameRoundService;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class RacingGameController {

    private final CarService carService;
    private final GameRoundService gameRoundService;
    private final Random random = new Random();
    private final int MAX_INCLUSIVE = 10;

    public RacingGameController(CarService carService, GameRoundService gameRoundService) {
        this.carService = carService;
        this.gameRoundService = gameRoundService;
    }

    public void createCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            carService.addCar(new Car());
        }
    }

    public void createGameRound(int numberOfAttempts) {
        gameRoundService.create(new GameRound(numberOfAttempts));
    }

    public void raceEachRound() {
        carService.findCars().forEach(car -> car.move(random.nextInt(MAX_INCLUSIVE)));
    }

    public void printGameResult() {
        ResultView.INSTANCE.printResultStatement();

        for (int i = 0; i < gameRoundService.loadGameRound().getRound(); i++) {
            raceEachRound();
            ResultView.INSTANCE.printEachRoundResult(carService.findMovementRangeOfCars());
        }
    }
}
