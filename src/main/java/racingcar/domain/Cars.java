package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String NOT_FOUND_POSITION = "최고 포지션을 찾을 수 없습니다.";
    private static final String MIN_LENGTH_FORNAT = "자동차는 %s개 이상이여야 합니다.";
    private static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars readyCars(final String carNames, final MoveStrategy moveStrategy) {
        return new Cars(generate(split(carNames), moveStrategy));
    }

    private static String[] split(final String carNames) {
        return carNames.split(DELIMITER);
    }

    private static List<Car> generate(final String[] carNames, final MoveStrategy moveStrategy) {
        validate(carNames);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, moveStrategy));
        }
        return cars;
    }

    private static void validate(final String[] carNames) {
        if (carNames.length < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(MIN_LENGTH_FORNAT, MIN_NUMBER));
        }
    }

    public List<CarResult> race() {
        List<CarResult> carResults = new ArrayList<>();
        for (Car car : this.cars) {
            car.racing();
            carResults.add(new CarResult(car));
        }
        return carResults;
    }

    public List<CarResult> winners() {
        Car winner = findWinner();
        return this.cars
                .stream()
                .filter(car -> car.isWinner(winner))
                .map(CarResult::new)
                .collect(Collectors.toList());
    }

    private Car findWinner() {
        return this.cars
                .stream()
                .max(Car::comparePosition)
                .orElseThrow(() -> new IllegalStateException(NOT_FOUND_POSITION));
    }

    public List<Car> getCars() {
        return cars;
    }
}
