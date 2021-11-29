package racing.refactor.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class CarRacingGame {

    private static final int ZERO = 0;

    private final List<Car> cars;

    public CarRacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        Position topPosition = topPosition();
        return cars.stream()
                .filter(car -> car.equalsPosition(topPosition))
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    protected Position topPosition() {
        int maxNumber = cars.stream()
                .mapToInt(value -> value.getPosition()
                                        .getValue()
                )
                .max()
                .orElse(ZERO);
        return new Position(maxNumber);
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public static List<Car> instanceOfCarNames(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
