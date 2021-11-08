package racingcar.domain;

import racingcar.exception.CreateCarCountException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars implements Comparable<Cars> {
    private static final int MIN_CREATE_COUNT = 1;

    private final List<Car> cars;

    private Cars(int count) {
        validateCreateCount(count);

        this.cars = Stream.generate(Car::from)
                .limit(count)
                .collect(Collectors.toList());
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(int count) {
        return new Cars(count);
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private void validateCreateCount(int count) {
        if (count < MIN_CREATE_COUNT) {
            throw new CreateCarCountException(count);
        }
    }

    public void move(MovingStrategy strategy) {
        cars.forEach(car -> car.move(strategy.generateNumber()));
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public int compareTo(Cars other) {
        if (this == other) return 0;
        if (other == null || getClass() != other.getClass()) return -1;
        if (cars.size() != other.size()) return -1;

        for (int i = 0; i < cars.size(); i++) {
            if (!cars.get(i).equals(other.cars.get(i))) {
                return -1;
            }
        }

        return 0;
    }
}
