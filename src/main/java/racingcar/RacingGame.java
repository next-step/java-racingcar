package racingcar;

import racingcar.strategy.MovingStrategy;

public class RacingGame {
    private final Positive carNums;
    private final Positive tryNums;
    private final RacingRecord racingRecord = new RacingRecord();

    public RacingGame(int carNums, int tryNums) {
        this.carNums = new Positive(carNums);
        this.tryNums = new Positive(tryNums);
    }

    public RacingRecord racingStart(MovingStrategy movingStrategy) {
        RoundCars roundCars = new RoundCars(carNums.getNumber());
        for (int round = 0; round < tryNums.getNumber(); round++) {
            racingRecord.createNewRoundRecord();
            roundCars.moveCars(racingRecord, movingStrategy);
        }
        return racingRecord;
    }
}
