package model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.cars = cars;
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
            racingRecord.save(turn, car.toRecord());
        }
    }

    public List<String> winnerNames() {
        int maxPosition = maxPosition();
        return this.cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(toList());
    }

    private int maxPosition() {
        return this.cars.stream()
                .map(Car::getPosition)
                .reduce(0, Math::max);
    }
}
