package model;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public RacingRecord run(int turn) {
        if (turn < 1) {
            throw new IllegalArgumentException("1이상 입력해주세요");
        }

        RacingRecord racingRecord = new RacingRecord(turn);
        for (int i = 1; i <= turn; i++) {
            Cars movedCars = cars.move();
            racingRecord.save(movedCars);
        }

        racingRecord.saveWinners(this.cars.winners());
        return racingRecord;
    }
}
