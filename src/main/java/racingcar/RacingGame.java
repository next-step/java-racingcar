package racingcar;

import java.util.List;
import racingcar.strategy.MovingStrategy;

public class RacingGame {

    private final Positive tryNums;
    private final List<String> carNames;
    private final RacingRecord racingRecord = new RacingRecord();

    public RacingGame(int tryNums, List<String> names) {
        this.tryNums = new Positive(tryNums);
        this.carNames = names;
    }

    public RacingRecord racingStart(MovingStrategy movingStrategy) {
        RoundCars roundCars = new RoundCars(carNames);
        for (int round = 0; round < tryNums.getNumber(); round++) {
            roundCars.moveCars(racingRecord, movingStrategy);
        }
        racingRecord.addWinners(roundCars.retrieveWinners());
        return racingRecord;
    }
}
