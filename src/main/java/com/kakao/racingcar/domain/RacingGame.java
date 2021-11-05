package com.kakao.racingcar.domain;

import java.util.stream.IntStream;

import static com.kakao.racingcar.domain.CarConfig.BEGIN_INDEX;
import static com.kakao.racingcar.domain.CarConfig.randomNumberGenerator;

public class RacingGame {
    private final int tryCount;
    private final CarCollection carCollection;

    public RacingGame(int tryCount, int totalCars) {
        this.tryCount = tryCount;
        this.carCollection = new CarCollection(totalCars);
    }

    public void runRace() {
        IntStream.range(BEGIN_INDEX, tryCount).boxed()
                .forEach(x -> carCollection.tryMoveCars(randomNumberGenerator(carCollection.size())));
    }

}
