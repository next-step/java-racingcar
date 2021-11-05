package racingcar.domain;

import racingcar.exception.CreateCarCountException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
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
        cars.forEach(car -> car.move(strategy));
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
