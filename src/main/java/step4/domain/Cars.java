package step4.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(CarNames carNames) {
        return new Cars(carNames.getCarNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
