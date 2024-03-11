package model;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public RacingRecord run(int turn) {
        RacingRecord racingRecord = new RacingRecord(turn);
        for (int t = 1; t <= turn; t++) {
            Cars movedCars = cars.move();
            racingRecord.save(movedCars);
        }

        return racingRecord;
    }

    public List<String> winnerNames() {
        return this.cars.winnerNames();
    }

}
