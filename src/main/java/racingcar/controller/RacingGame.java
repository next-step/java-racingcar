package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameRequest;
import racingcar.model.WinningResult;

import java.util.List;

public class RacingGame {

    public static final int MIN_ROUND = 0;
    private Cars cars;
    private int round;

    RacingGame(int round, Cars cars) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingGame generate(GameRequest gameRequest) {
        int round = gameRequest.getInputOfRound();
        Cars cars = Cars.from(gameRequest.getNames());
        return new RacingGame(round, cars);
    }

    public Cars start() {
        return cars;
    }

    public Cars playOfOneRound() {
        round--;
        return cars.move();
    }

    public boolean isGameOver() {
        return MIN_ROUND == round;
    }

    public List<String> getWinningResult() {
        return WinningResult.ofWinningCars(cars);
    }
}
