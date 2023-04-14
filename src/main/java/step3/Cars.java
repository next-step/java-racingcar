package step3;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(NumberGenerator numberGenerator, int numberOfCars) {
        Engine engine = new Engine(numberGenerator);
        List<Car> cars = IntStream.range(0, numberOfCars)
                .mapToObj(x -> Car.of(engine))
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
