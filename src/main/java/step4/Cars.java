package step4;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(NumberGenerator numberGenerator, List<String> names) {
        Engine engine = new Engine(numberGenerator);
        List<Car> cars = names.stream()
                .map(name -> Car.of(engine, name))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
