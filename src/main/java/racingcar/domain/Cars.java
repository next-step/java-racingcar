package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String[] carNames, Engine engine) {
        cars = Arrays.stream(carNames)
            .map(name -> new Car(name, engine))
            .collect(Collectors.toList());
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }
}
