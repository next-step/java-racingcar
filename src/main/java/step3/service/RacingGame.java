package step3.service;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.MoveStrategy;
import step3.dto.RacingGameCondition;
import step3.exception.MinimumTryCountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {


    private static final int MIN_TRY_COUNT = 1;
    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final RacingGameCondition racingGameCondition;

    public RacingGame(RacingGameCondition racingGameCondition, MoveStrategy moveStrategy) {
        this.racingGameCondition = racingGameCondition;
        validTryCount(getRacingGameTryCount());
        this.moveStrategy = moveStrategy;

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < getRacingGameCarCount(); i++) {
            carList.add(new Car());
        }
        cars = new Cars(carList);
    }

    public int getRacingGameTryCount() {
        return this.racingGameCondition.getTryCount();
    }

    private int getRacingGameCarCount() {
        return this.racingGameCondition.getCarCount();
    }


    public Cars getGameRoundResult() {
        cars.moveCars(moveStrategy);
        return cars;
    }

    private void validTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new MinimumTryCountException();
        }

    }
}
