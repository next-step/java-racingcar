package study.racing.domain;


import study.racing.factory.CarFactory;
import study.racing.util.RandomNumberGenerator;

import java.util.List;

public class RacingGame {
    private RacingRecord racingRecord;
    private List<Car> racingCars;
    private int totalRound;

    public RacingGame(String[] carNames, int totalRound) {
        this.participate(carNames);
        this.totalRound = totalRound;
    }

    private void participate(String[] carNames) {
        racingCars = CarFactory.createCars(carNames, new RandomMovingCondition());
        racingRecord = new RacingRecord(racingCars);
    }

    public void race() {
        for (int i = 1; i <= totalRound; i++) {
            int round = i;
            racingCars.forEach(car -> {
                race(car, round);
            });
        }
    }

    private void race(Car car, int round) {
        car.move(RandomNumberGenerator.getInstance().generate());
        racingRecord.record(car, round, car.getDistance());
    }

    public RacingRecord getRacingRecord() { return this.racingRecord; }

    public List<Car> getRacingCars() {
        return this.racingCars;
    }
}
