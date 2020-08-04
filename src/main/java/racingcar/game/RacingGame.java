package racingcar.game;

import racingcar.car.Cars;
import racingcar.car.CountOfCars;
import racingcar.engine.RandomPowerEngine;

public class RacingGame {
    private Cars cars;
    private int round;

    private RacingGame(int count, int round) {
        CountOfCars countOfCars = CountOfCars.newInstance(count);
        this.cars = Cars.newInstance(countOfCars, new RandomPowerEngine());
        this.round = round;
    }

    public static RacingGame newGame(int countOfCars, int round) {
        return new RacingGame(countOfCars, round);
    }

    public Results go() {
        Results results = Results.newInstance();

        for (int i = 0; i < this.round; i++) {
            cars.move();
            results.add(Result.newInstance(this.cars));
        }

        return results;
    }
}
