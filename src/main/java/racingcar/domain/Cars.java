package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.MovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final int INT_ZERO = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public Cars(String[] racingCarNames) {
        validateRacingCarSize(racingCarNames);
        this.cars = carNamesToList(racingCarNames);
    }

    private void validateRacingCarSize(String[] racingCarNames) {
        if (Objects.isNull(racingCarNames) || racingCarNames.length <= INT_ZERO) {
            throw new IllegalArgumentException("자동차의 개수는 1보다 커야 합니다.");
        }
    }

    private List<Car> carNamesToList(String[] racingCarNames) {
        return Stream.of(racingCarNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public Cars findWinners() {
        int maxPosition = calculateMaxPosition();
        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("값을 비교할 수 없습니다."));
    }

    public Cars moveAll(MovingStrategy movingStrategy) {
        List<Car> executedCars = new ArrayList<>();

        for (Car car : cars) {
            executedCars.add(car.move(movingStrategy));
        }
        return new Cars(executedCars);
    }
}
