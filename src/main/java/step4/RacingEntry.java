package step4;

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
                .filter(car -> isSameLocation(maxLocation, car.getLocation()))
                .collect(Collectors.toList());
    }

    private boolean isSameLocation(int maxLocation, int location) {
        return maxLocation == location;
    }

    private int findMaxLocation() {
        return this.cars.stream()
                .max(Comparator.comparing(Car::getLocation))
                .orElse(new Car(""))
                .getLocation();
    }
}
