package racingcargame.domain.vehicle;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcargame.domain.common.Distance;
import racingcargame.domain.common.Name;

public class WinnerCars {

    private final List<Car> cars;

    public WinnerCars(Cars cars) {
        Distance farthestDistance = cars.findFarthestDistance();
        this.cars = cars.findByDistance(farthestDistance).getCars();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Name> getNames() {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
