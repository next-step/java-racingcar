package racingcar.domain;

import racingcar.dto.Record;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static final int RANDOM_MIN_VALUE = 0;
    public static final int RANDOM_MAX_VALUE = 9;

    private final List<Car> cars;

    private Racing(List<Car> cars) {
        this.cars = cars;
    }

    public static Racing create(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        for(String carName: carNames) {
            Car car = Car.create(carName);
            carList.add(car);
        }

        return new Racing(carList);
    }

    public List<Record> start() {
        List<Record> records = new ArrayList<>();

        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
            int currentMoveCount = car.move(randomNumber);
            records.add(new Record(car.getName(), currentMoveCount));
        }

        return records;
    }

    public List<Car> getCars() {
        return cars;
    }
}
