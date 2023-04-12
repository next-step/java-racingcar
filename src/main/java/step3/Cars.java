package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(int numberOfCars) {
        Engine engine = new Engine(new RandomNumberGenerator());
        List<Car> cars = IntStream.range(0, numberOfCars)
                .mapToObj(x -> Car.of(engine))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
