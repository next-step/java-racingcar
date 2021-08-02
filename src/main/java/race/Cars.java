package race;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(Condition condition) {
        this.cars = condition.getNames().stream()
                .map(name -> Car.of(condition.getTryCount(), name))
                .collect(Collectors.toList());
    }

    public static Cars of(Condition condition) {
        return new Cars(condition);
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public String getWinner(int highDistance) {
        return cars.stream()
                .filter(car -> car.getDistance(car.getMaxTryCount()) >= highDistance)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
