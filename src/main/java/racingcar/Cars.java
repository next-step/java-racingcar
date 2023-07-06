package racingcar;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static racingcar.RandomGenerator.generateNumber;

public class Cars {

    private static final String NOT_EMPTY_CAR_MESSAGE = "Car 객체를 찾을 수 없습니다.";
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        return new Cars(carNames.stream()
                .distinct()
                .map(Car::new)
                .collect(toList()));
    }

    public void takeTurn() {
        for (Car car : cars) {
            car.progress(generateNumber());
        }
    }

    public List<String> findWinnerNames() {
        int maxDistance = findMaxCarDistance();
        return cars.stream()
                .filter(car -> car.isMaxDistance(maxDistance))
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
        return cars;
    }
}
