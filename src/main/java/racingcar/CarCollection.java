package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    private List<Car> cars;

    public CarCollection(List<Car> cars) {
        this.cars = cars;
    }

    public void forward(MovementCondition movementCondition) {
        cars.forEach(car -> car.forward(movementCondition));
    }

    public List<String> getWinnersName() {
        int maxDistance = getMaxDistance(cars);
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .get()
                .getDistance();
    }
}
