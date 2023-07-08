package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {
    private final Cars cars;
    private final int round;
    private final RacingRecord racingRecord;

    public RacingManager(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
        this.racingRecord = new RacingRecord();
        racingRecord.add(cars.getRecord());
    }

    public static RacingManager of(List<String> carNames, int round) {
        return new RacingManager(Cars.from(carNames), round);
    }

    public void playRacing() {
        for (int i = 0; i < round; i++) {
            cars.takeTurn();
            racingRecord.add(cars.getRecord());
        }
    }

    public RacingRecord getRacingRecord() {
        return racingRecord;
    }

    public List<String> getWinnerCarNames() {
        return cars.getMaxDistanceCarNames();
    }
}
