package racingcar.domain;

import racingcar.exception.CreateCarCountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final int MIN_CREATE_COUNT = 1;

    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    private Cars(int count, MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
        validateCreateCount(count);

        this.cars = Stream.generate(Car::from)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static Cars from(int count, MovingStrategy movingStrategy) {
        return new Cars(count, movingStrategy);
    }

    private void validateCreateCount(int count) {
        if (count < MIN_CREATE_COUNT) {
            throw new CreateCarCountException(count);
        }
    }

    public void move() {
        cars.forEach(car -> car.move(movingStrategy.generateNumber()));
    }

    public List<Integer> carsPosition() {
        List<Integer> carsPosition = new ArrayList<>();
        cars.forEach(car -> carsPosition.add(car.currentPosition()));

        return carsPosition;
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
