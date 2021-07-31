package racingcar.domain;

import racingcar.utils.RandomGenerate;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final int BOUND_RANDOM_NUMBER = 10;
    private final Car[] racingCars;

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
        List<RacingRecords> racingRecordsList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            racingRecordsList.add(moveTryCars());
        }
        return racingRecordsList;
    }

    private RacingRecords moveTryCars() {
        RacingRecords racingRecords = new RacingRecords();
        for (Car car : racingCars) {
            car.move(RandomGenerate.pickRandomNumber(BOUND_RANDOM_NUMBER));
            racingRecords.add(new RacingRecord(car, car.getPosition()));
        }
        return racingRecords;
    }

    public Car[] getRacingCars() {
        return racingCars;
    }
}

