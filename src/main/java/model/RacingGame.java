package model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(int numOfCars) {
        this(numOfCars, new RandomMove());
    }

    public RacingGame(int numOfCars, MoveStrategy moveStrategy) {
        this.cars = participate(numOfCars, moveStrategy);
    }

    public RacingGame(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.cars = cars;
    }

    private List<Car> participate(int numOfCars, MoveStrategy moveStrategy) {
        List<Car> result = new ArrayList<>();
        for (int i = 1; i <= numOfCars; i++) {
            result.add(new Car(moveStrategy));
        }

        return result;
    }

    public RacingRecord run(int turn) {
        RacingRecord racingRecord = new RacingRecord(turn);
        for (int t = 1; t <= turn; t++) {
            move();
            record(t, racingRecord);
        }

        return racingRecord;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void record(int turn, RacingRecord racingRecord) {
        for (Car car : cars) {
            racingRecord.record(turn, car);
        }
    }
}
