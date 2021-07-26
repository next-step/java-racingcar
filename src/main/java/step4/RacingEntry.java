package step4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingEntry {

    private final List<Car> cars;

    public RacingEntry(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars.subList(0, this.cars.size());
    }

    public List<Car> findWinners() {
        final int maxLocation = findMaxLocation();

        return this.cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .collect(Collectors.toList());
    }

    private int findMaxLocation() {
        return this.cars.stream()
                .max(Comparator.comparing(Car::getLocation))
                .orElse(new Car(""))
                .getLocation();
    }
}
