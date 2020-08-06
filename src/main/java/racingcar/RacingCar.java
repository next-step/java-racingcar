package racingcar;

import java.util.Random;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class RacingCar {
    private static final int FIRST_ATTEMPT = 0;
    private static final int MOVE_LIMIT_COUNT = 4;

    private Random random;
    private RaceRecord raceRecord;

    private RacingCar(Random random) {
        this.random = random;
        raceRecord = new RaceRecord();
    }

    public static RacingCar create(Random random) {
        return new RacingCar(random);
    }

    public RaceRecord getRaceRecord() {
        return raceRecord;
    }

    public void race(int attemptNumber) {
        for (int attempt = 0; attempt < attemptNumber; attempt++) {
            moveCar(attempt);
        }
    }

    private void moveCar(int attempt) {
        int move = (attempt == FIRST_ATTEMPT)
                ? 0
                : raceRecord.getBy(attempt - 1);

        if (this.canMove()) {
            move += 1;
        }

        raceRecord.add(move);
    }

    private boolean canMove() {
        return random.nextInt(10) >= MOVE_LIMIT_COUNT;
    }
}
