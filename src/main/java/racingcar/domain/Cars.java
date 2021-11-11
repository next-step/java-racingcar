package racingcar.domain;

import racingcar.exception.CreateCarCountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_CREATE_COUNT = 1;

    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    private Cars(String[] carNames, MovingStrategy movingStrategy) {
        validateMovingStrategy(movingStrategy);
        validateCreateCount(carNames.length);

        this.movingStrategy = movingStrategy;
        this.cars = Arrays.stream(carNames)
                .map(Car::from)
                .collect(Collectors.toList());
    }

    private void validateMovingStrategy(MovingStrategy movingStrategy) {
        if (Objects.isNull(movingStrategy)) {
            throw new IllegalArgumentException();
        }
    }

    public static Cars from(String[] carNames, MovingStrategy movingStrategy) {
        return new Cars(carNames, movingStrategy);
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
