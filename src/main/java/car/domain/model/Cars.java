package car.domain.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final String inputCarNames) {
        CarNames carNames = new CarNames(inputCarNames);
        cars = carNames.getCarNames().stream()
            .map(CarName::getMyCarName)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private String[] tokenCarNames(final String carNames) {
        return carNames.split(",");
    }

    public void raceOnce() {
        this.cars.forEach(o -> o.move());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
