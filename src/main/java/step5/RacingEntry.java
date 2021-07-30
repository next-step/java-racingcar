package step5;

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

    public List<Car> findWinnerCars() {
        CarLocation maxLocation = findMaxLocation();

        return this.cars.stream()
                .filter(car -> car.isWinner(maxLocation))
                .collect(Collectors.toList());
    }

    private CarLocation findMaxLocation() {
        return this.cars.stream()
                .max(Car::compareTo)
                .orElse(new Car(""))
                .getCarLocation();
    }
}
