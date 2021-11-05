package racingcar;

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

    public static Cars from(int count) {
        return new Cars(count);
    }

    private void validateCreateCount(int count) {
        if (count < MIN_CREATE_COUNT) {
            throw new CreateCarCountException(count);
        }
    }

    public void move(TryCount tryCount, MovingStrategy strategy) {
        while (tryCount.nonOver()) {
            tryCount.counting();
            cars.forEach(car -> car.move(strategy));
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
