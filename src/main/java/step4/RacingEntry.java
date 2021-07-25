package step4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingEntry {

    private final List<Car> cars;

    public RacingEntry(List<String> carNames) {
        this.cars = registerCars(carNames);
    }

    private List<Car> registerCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars.subList(0, this.cars.size());
    }

    public List<Car> findWinners() {
        int maxLocation = findMaxLocation();

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
