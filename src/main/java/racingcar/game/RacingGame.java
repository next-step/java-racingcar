package racingcar.game;

import racingcar.car.CarNames;
import racingcar.car.Cars;
import racingcar.engine.RandomPowerEngine;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private int round;

    private RacingGame(String nameValues, int round) {
        CarNames carNames = CarNames.newInstance(nameValues);
        this.cars = Cars.newInstance(carNames, new RandomPowerEngine());
        this.round = round;
    }

    public static RacingGame newGame(String nameValues, int round) {
        return new RacingGame(nameValues, round);
    }

    public RacingGameResult go() {
        RacingGameResult racingGameResult = RacingGameResult.newInstance();

        for (int i = 0; i < this.round; i++) {
            List<CarStatus> roundStatus = cars.move();
            racingGameResult.add(RoundResult.newInstance(roundStatus));
        }

        return racingGameResult;
    }
}
