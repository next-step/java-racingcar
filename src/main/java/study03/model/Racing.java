package study03.model;

import java.util.stream.IntStream;

/*
 *
 * Racing
 *
 * @version 1.0.0
 *
 * 2021-11-10
 *
 * Copyright tnals1422
 */
public class Racing {

    private final int roundCount;
    private final Cars cars;
    private final RacingResult racingResult;

    public Racing(int carCount, int roundCount) {
        cars = new Cars(carCount);
        this.roundCount = roundCount;
        this.racingResult = new RacingResult();
    }

    public RacingResult start() {
        IntStream.range(0, roundCount)
                .forEach(i -> {
                    cars.tryMovingCarsPerRound();
                    racingResult.add(new RoundResult(cars));
                });
        return racingResult;
    }
}
