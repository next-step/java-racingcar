package car.racing.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(final String carNames) {
        cars = Arrays.stream(tokenCarNames(carNames))
            .map(CarName::new)
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
