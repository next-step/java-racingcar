package racingcar.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static racingcar.domain.RandomGenerator.generateNumber;

public class Cars {

    private static final String NOT_EMPTY_CAR_MESSAGE = "Car 객체를 찾을 수 없습니다.";
    private static final String DUPLICATE_CAR_NAME_MESSAGE = "자동차 이름에 중복이 있습니다.";
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateCarNames(cars);
        this.cars = cars.stream()
                .map(Car::new)
                .collect(toUnmodifiableList());
    }

    public Cars copy() {
        return new Cars(this.cars);
    }

    private void validateCarNames(final List<Car> cars) {
        long distinctSize = cars.stream()
                .distinct()
                .count();
        if (distinctSize != cars.size()) throw new IllegalStateException(DUPLICATE_CAR_NAME_MESSAGE);
    }

    public void takeTurn() {
        for (Car car : cars) {
            car.progress(generateNumber());
        }
    }

    public List<String> findWinnerNames() {
        int maxDistance = findMaxCarDistance();
        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .map(Car::getName)
                .collect(toList());
    }

    private int findMaxCarDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalStateException(NOT_EMPTY_CAR_MESSAGE));
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
