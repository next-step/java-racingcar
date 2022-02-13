package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this(Arrays.stream(carNames).map(Car::new).collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
