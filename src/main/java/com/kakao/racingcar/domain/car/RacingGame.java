package com.kakao.racingcar.domain.car;

import com.kakao.racingcar.history.CarHistory;
import com.kakao.racingcar.history.RacingHistory;
import com.kakao.racingcar.history.RoundHistory;
import com.kakao.racingcar.util.RandomNumberGenerator;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.kakao.racingcar.config.CarConstant.BEGIN_INDEX;

public class RacingGame {
    private final int tryCount;
    private final CarCollection carCollection;
    private final RacingHistory racingHistory;

    public RacingGame(int tryCount, List<String> userNames) {
        this.tryCount = tryCount;
        this.carCollection = new CarCollection(userNames);
        this.racingHistory = new RacingHistory();
    }

    public void runRace() {
        IntStream.range(BEGIN_INDEX, tryCount).boxed()
                .forEach(round -> {
                    List<CarHistory> carHistories = carCollection.tryMoveCars(RandomNumberGenerator.generate(carCollection.size()));
                    racingHistory.logging(new RoundHistory(round, carHistories));
                });
    }

    public RacingHistory getRacingHistory() {
        return racingHistory;
    }

}
