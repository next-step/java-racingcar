package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    public static final int RANDOM_BOUND = 10;
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public boolean isEmpty() {
        return cars == null || cars.isEmpty();
    }

    public void race(Random random) {
        for (Car car : cars) {
            car.moveOrStop(random.nextInt(RANDOM_BOUND));
        }
    }

    public void saveRecords(List<Record> records) {
        for (Car car : cars) {
            records.add(car.extractRecord());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
