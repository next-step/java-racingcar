package racingcar.domain;

import racingcar.exception.CreateCarCountException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    public void move(MovingStrategy strategy) {
        cars.forEach(car -> car.move(strategy.generateNumber()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars other = (Cars) o;
        if (cars.size() != other.cars.size()) return false;
        for (int i = 0; i < cars.size(); i++) {
            if (!cars.get(i).equals(other.cars.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
