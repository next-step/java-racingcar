package step3.logic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private final List<Car> cars;

    public Race(int numberCars) {
        cars = IntStream.range(0, numberCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void lap() {
        cars.forEach(car -> car.run(car.getThrottle()));
    }
}
