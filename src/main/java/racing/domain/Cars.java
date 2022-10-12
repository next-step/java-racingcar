package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int DEFAULT_VALUE = 0;
    private static final String DELIMITER = ", ";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(MovableStrategy movableStrategy) {
        cars.forEach(car -> car.move(movableStrategy));
    }

    public String findWinners() {
        int maxPostion = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(DEFAULT_VALUE);

        return cars.stream()
            .filter(car -> car.equalsPosition(maxPostion))
            .map(Car::getName)
            .collect(Collectors.joining(DELIMITER));
    }

}
