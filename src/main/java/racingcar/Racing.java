package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final int BOUND_RANDOM_NUMBER = 10;
    private final int MORE_THEN_STANDARD_NUMBER = 4;

    private Car[] racingCars;

    public Racing() {
        this(10);
    }

    public Racing(int carCount) {
        racingCars = new Car[carCount];
        addCars();
    }

    private void addCars() {
        for (int i = 0; i < racingCars.length; i++) {
            racingCars[i] = new Car();
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

