package carracing;

import java.util.*;
import java.util.stream.Collectors;

public class Track {

    private final List<Car> cars;

    public Track(List<CarName> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Round forward() {
        cars.forEach(car -> {
            int random = RandomFactory.generate(Car.RANDOM_BOUND);
            car.stepForwardByRandomNumber(random);
        });
        return new Round(cars);
    }
}
