package racingcar.domain;

import static racingcar.config.RacingCarException.CAR_NAME_DUPLICATED;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveForwardOrStop(final MovementStrategy movementStrategy) {
        this.cars.forEach(car -> car.moveForwardOrStop(movementStrategy));
    }

    public List<String> winnerNames() {
        final int maxPosition = maxPosition();

        return this.cars().stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::name)
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return this.cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public List<Car> cars() {
        return this.cars.stream()
                .map(Car::copyOf)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Cars from(final String[] carNames) {
        validateCarNamesAreNotDuplicated(carNames);

        return new Cars(readyCars(carNames));
    }

    private static void validateCarNamesAreNotDuplicated(String[] carNames) {
        if (areCarNamesDuplicated(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED.message(carNames));
        }
    }

    private static boolean areCarNamesDuplicated(final String[] carNames) {
        return distinctCarNamesCount(carNames) != carNames.length;
    }

    private static long distinctCarNamesCount(final String[] carNames) {
        return Arrays.stream(carNames)
                .distinct()
                .count();
    }

    private static List<Car> readyCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::from)
                .collect(Collectors.toList());
    }
}
