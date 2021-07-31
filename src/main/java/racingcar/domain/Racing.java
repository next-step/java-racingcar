package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utils.RandomGenerate.pickRandomNumber;

public class Racing {

    private final Car[] racingCars;
    private final MoveStrategy moveStrategy;

    public Racing(String[] carNames) {
        racingCars = new Car[carNames.length];
        moveStrategy = new RacingMoveStrategy();
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
            moveTryCar(car);
            racingRecords.add(new RacingRecord(car, car.getPosition()));
        }
        return racingRecords;
    }

    private void moveTryCar(Car car) {
        int randomNumber = pickRandomNumber();
        car.move(randomNumber);
    }

    public Car[] getRacingCars() {
        return racingCars;
    }
}

