package racingcar.domain;

import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int BOUND_NUMBER = 10;

    public GameResult run(List<String> carNames, int runCount) {

        List<Records> records = new ArrayList<>();
        List<Car> cars = readyCars(carNames);

        for (int i = 0; i < runCount; i++) {
            List<CarRecord> record = doCycle(cars);
            records.add(new Records(record));
        }
        return new GameResult(records);
    }

    private List<CarRecord> doCycle(List<Car> cars) {
        List<CarRecord> carRecord = new ArrayList<>();
        for (Car car : cars) {
            car.move(RandomGenerator.getRandomInteger(BOUND_NUMBER));
            carRecord.add(CarRecord.of(car));
        }

        return carRecord;
    }

    private List<Car> readyCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {

            cars.add(new Car(carName));
        }
        return cars;
    }

}
