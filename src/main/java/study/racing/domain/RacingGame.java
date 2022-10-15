package study.racing.domain;


import study.racing.factory.CarFactory;
import study.racing.util.RandomNumberGenerator;

import java.util.List;

public class RacingGame {
    private RacingRecord racingRecord;
    private List<Car> racingCars;

    public void participate(String[] carNames) {
        racingCars = CarFactory.createCars(carNames, new RandomMovingCondition());
        racingRecord = new RacingRecord(racingCars);
    }

    public void race(int loopCount) {
        for (int i = 1; i <= loopCount; i++) {
            int round = i;

            racingCars.forEach(car -> {
                car.move(RandomNumberGenerator.getInstance().generate());
                racingRecord.record(car, round, car.getDistance());
            });
        }
    }

    public RacingRecord getRacingRecord() { return this.racingRecord; }

    public List<Car> getRacingCars() {
        return this.racingCars;
    }
}
