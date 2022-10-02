package racingcar;

import java.util.List;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomStrategy;

public class RacingGame {

    public static final int FORWARD_CONDITION_LOW_BOUND = 4;
    public static final int FORWARD_CONDITION_HIGH_BOUND = 9;

    private final PositiveNumber tryNums;
    private final List<String> carNames;
    private final RacingRecord racingRecord = new RacingRecord();
    private MovingStrategy movingStrategy;

    public RacingGame(int tryNums, List<String> names) {
        this.tryNums = new PositiveNumber(tryNums);
        this.carNames = names;
        this.movingStrategy = new RandomStrategy(FORWARD_CONDITION_LOW_BOUND, FORWARD_CONDITION_HIGH_BOUND);
    }

    public RacingRecord racingStart() {
        RoundCars roundCars = new RoundCars(carNames);
        for (int round = 0; round < tryNums.getNumber(); round++) {
            roundCars.moveCars(racingRecord, movingStrategy);
        }
        racingRecord.addWinners(roundCars.retrieveWinners());
        return racingRecord;
    }

    public void changeMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }
}
