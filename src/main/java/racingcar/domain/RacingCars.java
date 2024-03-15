package racingcar.domain;

import static java.text.MessageFormat.format;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final String DUPLICATED_CAR_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다. [carNames: {0}]";

    private final List<Car> cars;

    public RacingCars(final String[] carNames) {
        validateCarNamesAreNotDuplicated(carNames);

        this.cars = readyCars(carNames);
    }

    private void validateCarNamesAreNotDuplicated(String[] carNames) {
        if (areCarNamesDuplicated(carNames)) {
            throw new IllegalArgumentException(format(DUPLICATED_CAR_NAME_MESSAGE, Arrays.toString(carNames)));
        }
    }

    private boolean areCarNamesDuplicated(final String[] carNames) {
        return distinctCarNamesCount(carNames) != carNames.length;
    }

    private long distinctCarNamesCount(final String[] carNames) {
        return Arrays.stream(carNames)
                .distinct()
                .count();
    }

    private static List<Car> readyCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveForwardOrStop(final CarMovement carMovement) {
        this.cars.forEach(car -> car.moveForwardOrStop(carMovement));
    }

    public List<String> winnerNames() {
        final int maxPosition = maxPosition();

        return this.cars().stream()
                .filter(car -> car.isWinner(maxPosition))
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
}
