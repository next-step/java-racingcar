package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.TryCount;
import racingcar.dto.MoveResult;
import racingcar.dto.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private TryCount tryCount;

    private final int carCount;

    private final Cars cars;

    public Race(Integer tryCount, int carCount, MoveStrategy moveStrategy) {
        this.tryCount = new TryCount(tryCount);
        this.carCount = carCount;
        this.cars = new Cars(carCount, moveStrategy);
    }

    public RaceResult start() {
        List<MoveResult> moveLogs = new ArrayList<>();
        while (!this.tryCount.isComplete()) {
            MoveResult moveResult = cars.move();
            moveLogs.add(moveResult);
            this.tryCount = tryCount.getNextTryCount();
        }

        return new RaceResult(moveLogs);
    }

}
