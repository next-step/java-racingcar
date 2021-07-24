package racingcar.domain.vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        cars.forEach(this::add);
    }

    public void add(Car car) {
        cars.add(CarFactory.create(car.getEngine(), car.getNameValue(), car.getDistanceValue()));
    }

    public void doDrive() {
        cars.forEach(Car::drive);
    }

    public Names getWinnerNames() {
        Distance farthestDistance = findFarthestDistance();
        return findNamesByDistance(farthestDistance);
    }

    private Names findNamesByDistance(Distance distance) {
        List<Name> names = cars.stream()
            .filter(car -> car.getDistance().equals(distance))
            .map(Car::getName)
            .collect(Collectors.toList());

        return new Names(names);
    }

    private Distance findFarthestDistance() {
        return cars.stream()
            .map(Car::getDistance)
            .max(Comparator.naturalOrder())
            .orElseGet(() -> new Distance(0));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

