package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.random.RandomNumber;

public class Cars {
    private final List<Car> values;

    private static final int MIN_CAR_COUNT = 1;

    public Cars(int count) {
        validateCount(count);

        this.values = createCars(count);
    }

    private void validateCount(int count) {
        if (isInvalidCount(count)) {
            throw new IllegalArgumentException("자동차 대수는 1이상이어야 합니다.");
        }
    }

    private boolean isInvalidCount(int count) {
        return count < MIN_CAR_COUNT;
    }

    private List<Car> createCars(int count) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public void moveAll(RandomNumber randomNumber) {
        for (Car car : values) {
            car.move(randomNumber.generate());
        }
    }

    public int size() {
        return this.values.size();
    }

    public List<Integer> getDistances() {
        List<Integer> distances = new ArrayList<>();

        for (Car car : values) {
            distances.add(car.getDistance());
        }

        return distances;
    }
}
