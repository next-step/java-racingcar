package carracing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> get() {
        return cars;
    }

    public void go() {
        cars.forEach(Car::go);
    }

    public List<Car> getCarsAtCertainDistance(int distance) {
        return cars.stream()
                .filter(car -> car.isLocated(distance))
                .collect(Collectors.toList());
    }

    public int getMaxDistance() {
        return cars.stream().map(Car::getLocation).max(Comparator.comparingInt(o -> o)).orElse(0);
    }
}
