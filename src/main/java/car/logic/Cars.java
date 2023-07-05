package car.logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String carNames) {
        cars = Arrays.stream(tokenCarNames(carNames)).map(Car::new).collect(Collectors.toList());
    }

    private String[] tokenCarNames(String carNames) {
        return carNames.split(",");
    }

    public void raceOnce() {
        this.cars.forEach(o -> o.move());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
            "cars=" + cars +
            '}';
    }
}
