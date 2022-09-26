package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> winners) {
        this.cars = winners;
    }

    public String showWinnerNames() {
        return cars.stream()
                .map(Car::showName)
                .collect(Collectors.joining(","));
    }

    public int size() {
        return cars.size();
    }

    public boolean contain(Car car) {
        return cars.contains(car);
    }
}
