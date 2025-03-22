package racingcar.domain;

import java.util.List;
import java.util.Random;

public class Cars {

    public static final int RANDOM_BOUND = 10;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isEmpty() {
        return cars == null || cars.isEmpty();
    }

    public void race(Random random) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalStateException("경주를 하기 위해서는 적어도 한 대의 자동차가 있어야 합니다.");
        }

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
