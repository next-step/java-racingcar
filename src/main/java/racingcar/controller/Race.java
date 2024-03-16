package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.vo.NaturalNumber;
import racingcar.dto.MoveResult;
import racingcar.dto.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private NaturalNumber tryCount;

    private final NaturalNumber carCount;

    private final Cars cars;

    public Race(int tryCount, int carCount, MoveStrategy moveStrategy) {
        this.tryCount = new NaturalNumber(tryCount);
        this.carCount = new NaturalNumber(carCount);
        this.cars = new Cars(this.carCount.getValue(), moveStrategy);
    }

    public RaceResult start() {
        List<MoveResult> moveLogs = new ArrayList<>();

        for (int i = 0; i < tryCount.getValue(); i++) {
            MoveResult moveResult = cars.move();
            moveLogs.add(moveResult);
        }

        return new RaceResult(moveLogs);
    }

}
