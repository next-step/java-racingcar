package racingcar.domain;

import racingcar.domain.movable.Movable;

import java.util.List;

public class RacingManager {
    private final Cars cars;
    private final int round;
    private final RacingRecord racingRecord;

    public RacingManager(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
        this.racingRecord = new RacingRecord(cars.getRacingRoundRecord());
    }

    public static RacingManager of(List<String> carNames, int round) {
        return new RacingManager(Cars.from(carNames), round);
    }

    public void playRacing(Movable movable) {
        for (int i = 0; i < round; i++) {
            cars.takeTurn(movable);
            racingRecord.add(cars.getRacingRoundRecord());
        }
    }

    public RacingRecord getRacingRecord() {
        return racingRecord;
    }

    public List<String> getWinnerCarNames() {
        return cars.getMaxDistanceCarNames();
    }
}
