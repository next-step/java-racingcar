package racingcar.model;

import racingcar.model.wrapper.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final Cars cars;

    public Winners(final Cars cars) {
        this.cars = cars;
    }

    public List<CarName> result() {
        return cars.currentCars()
                .stream()
                .filter(car -> car.currentForwardCount() == cars.maxForwardCount())
                .map(Car::carName)
                .collect(Collectors.toUnmodifiableList());
    }
}
