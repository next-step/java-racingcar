package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final Car[] racingCars;
    private final MoveStrategy moveStrategy;

    public Racing(String[] carNames, MoveStrategy moveStrategy) {
        racingCars = new Car[carNames.length];
        this.moveStrategy = moveStrategy;
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
            car.move(moveStrategy);
            racingRecords.add(new RacingRecord(car, car.getPosition()));
        }
        return racingRecords;
    }

    public Car[] getRacingCars() {
        return racingCars;
    }
}

