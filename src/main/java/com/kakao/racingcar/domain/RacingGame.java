package com.kakao.racingcar.domain;

import com.kakao.racingcar.history.RacingHistory;
import com.kakao.racingcar.util.RandomNumberGenerator;

import java.util.stream.IntStream;

import static com.kakao.racingcar.config.CarConfig.BEGIN_INDEX;

public class RacingGame {
    private final int tryCount;
    private final CarCollection carCollection;
    private final RacingHistory racingHistory;

    public RacingGame(int tryCount, int totalCars) {
        this.tryCount = tryCount;
        this.carCollection = new CarCollection(totalCars);
        this.racingHistory = new RacingHistory();
    }

    public void runRace() {
        IntStream.range(BEGIN_INDEX, tryCount).boxed()
                .forEach(round -> {
                    carCollection.tryMoveCars(RandomNumberGenerator.generate(carCollection.size()));
                    racingHistory.logging(round, carCollection.getCars());
                });
    }

    public RacingHistory getRacingHistory() {
        return racingHistory;
    }

}
