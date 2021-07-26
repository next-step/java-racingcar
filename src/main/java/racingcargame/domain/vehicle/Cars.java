package racingcargame.domain.vehicle;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcargame.domain.common.Distance;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void doDrive() {
        cars.forEach(Car::drive);
    }

    public WinnerCars getWinners() {
        return new WinnerCars(this);
    }

    public Cars findByDistance(Distance distance) {
        List<Car> cars = this.cars.stream()
            .filter(car -> car.getDistance().equals(distance))
            .collect(Collectors.toList());

        return new Cars(cars);
    }

    public Distance findFarthestDistance() {
        return cars.stream()
            .map(Car::getDistance)
            .max(Distance::compareTo)
            .orElseGet(() -> new Distance(0));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
