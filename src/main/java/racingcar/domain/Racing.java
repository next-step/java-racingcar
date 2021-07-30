package racingcar.domain;

import racingcar.utils.RandomGenerate;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final int BOUND_RANDOM_NUMBER = 10;
    private final int MORE_THEN_STANDARD_NUMBER = 4;

    private Car[] racingCars;

    public Racing(String[] carNames) {
        racingCars = new Car[carNames.length];
        addCars(carNames);
    }

    private void addCars(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            racingCars[i] = new Car(carNames[i]);
        }
    }

    public List<RacingRecords> start(int tryCount) {
        List<RacingRecords> racingRecords = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            RacingRecords records = moveTryCars();
            racingRecords.add(records);
        }
        return racingRecords;
    }

    private RacingRecords moveTryCars() {
        List<RacingRecord> records = new ArrayList<>();
        for (Car car : racingCars) {
            moveTryCar(car);
            records.add(new RacingRecord(car, car.getPosition()));
        }
        return new RacingRecords(records);
    }

    private void moveTryCar(Car car) {
        if (isMoveAble()) {
            car.move();
        }
    }

    private boolean isMoveAble() {
        return RandomGenerate.pick(BOUND_RANDOM_NUMBER, MORE_THEN_STANDARD_NUMBER);
    }

    public Car[] getRacingCars() {
        return racingCars;
    }
}

