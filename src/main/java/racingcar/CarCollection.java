package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    private List<Car> cars;

    public CarCollection(List<Car> cars) {
        this.cars = cars;
    }

    public List<Distance> forward(MovementCondition movementCondition) {
        return cars.stream().
                map(car -> car.forward(movementCondition))
                .collect(Collectors.toList());
    }

    public List<Name> getWinnersName() {
        Distance maxDistance = getMaxDistance(cars);
        return cars.stream()
                .filter(car -> car.getDistance().equals(maxDistance))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private Distance getMaxDistance(List<Car> cars) {
        return cars.stream()
                .map(Car::getDistance)
                .max(Distance::compare)
                .get();
    }
}
