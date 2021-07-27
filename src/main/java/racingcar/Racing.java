package racingcar;

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

    public List<List<RacingRecord>> start(int tryCount) {
        List<List<RacingRecord>> racingRecords = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            List<RacingRecord> records = moveTryCars();
            racingRecords.add(records);
        }
        return racingRecords;
    }

    private List<RacingRecord> moveTryCars() {
        List<RacingRecord> records = new ArrayList<>();
        for (Car car : racingCars) {
            moveTryCar(car);
            records.add(new RacingRecord(car, car.getPosition()));
        }
        return records;
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

