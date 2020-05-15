package racingcar.domain;

import racingcar.exception.ErrorMessage;
import racingcar.moving.MovingStrategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public static Cars of(final String[] carNames) {
        validateCarNames(carNames);
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::of)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private Cars() {
    }

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    private static void validateCarNames(final String[] carNames) {
        if (carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PARAMETER);
        }
    }

    public void moveCars(final MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinnerCars() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(winnerCar -> cars.stream()
                        .filter(car -> car.isSamePosition(winnerCar.getPosition()))
                        .collect(Collectors.toList())
                ).orElseThrow(RuntimeException::new);
    }
}
