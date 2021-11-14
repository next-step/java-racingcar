package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> doRacing() {
        return cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());
    }

}
