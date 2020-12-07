package com.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Race {
    private static final String DELIMITER = ",";

    private int moveCount;
    private List<Car> cars = new ArrayList<>();
    private List<RaceRecord> raceRecords = new ArrayList<>();

    public Race(List<CarName> carNames, int moveCount, Supplier<Integer> numberGenerator) {
        this.moveCount = moveCount;
        for (CarName carName : carNames) {
            cars.add(new Car(carName, numberGenerator));
        }
    }

    public void run() {
        for (int ix = 0 ; ix < moveCount ; ix ++) {
            move();
        }
    }

    private void move() {
        RaceRecord raceRecord = new RaceRecord();
        for (Car car : cars) {
            car.tryMove();
            raceRecord.addCarRecord(car.record());
        }
        raceRecords.add(raceRecord);
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }

    public String getWinnerNames() {
        Car winner = getWinner();
        return cars.stream()
                .filter(car -> car.equalsPosition(winner))
                .map(Car::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    private Car getWinner() {
        Car winner = cars.get(0);
        for (Car car : cars) {
            winner = winner.compareAndGet(car);
        }
        return winner;
    }
}
