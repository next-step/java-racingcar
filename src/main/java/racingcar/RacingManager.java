package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {
    private final Cars cars;
    private final int round;
    private final List<RacingRoundRecord> records;

    public RacingManager(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
        records = new ArrayList<>();
        records.add(cars.getRecord());
    }

    public static RacingManager of(List<String> carNames, int round) {
        return new RacingManager(Cars.from(carNames), round);
    }

    public void playRacing() {
        for (int i = 0; i < round; i++) {
            cars.takeTurn();
            records.add(cars.getRecord());
        }
    }

    public List<RacingRoundRecord> getRecords() {
        return records;
    }

    public List<String> getWinnerCarNames() {
        return cars.getMaxDistanceCarNames();
    }
}
