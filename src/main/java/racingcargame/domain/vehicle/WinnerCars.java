package racingcargame.domain.vehicle;

import java.util.List;
import java.util.stream.Collectors;
import racingcargame.domain.common.Distance;
import racingcargame.domain.common.Name;

public class WinnerCars {

    private final List<Car> cars;

    public WinnerCars(List<Car> cars) {
        Distance farthestDistance = findFarthestDistance(cars);
        this.cars = cars.stream()
            .filter(car -> car.isEquals(farthestDistance))
            .collect(Collectors.toList());
    }

    private Distance findFarthestDistance(List<Car> cars) {
        return cars.stream()
            .map(Car::getDistance)
            .max(Distance::compareTo)
            .orElseGet(() -> new Distance(0));
    }

    public List<Name> getNames() {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
