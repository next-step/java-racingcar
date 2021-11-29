package carracing.cars;

import carracing.rounds.Round;

import java.util.*;
import java.util.stream.Collectors;

public class Track {

    private final List<Car> cars;

    public Track(List<CarName> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Round forward(StepForwardStrategy stepForwardStrategy) {
        cars.forEach(car -> {
            car.stepForward(stepForwardStrategy);
        });
        return new Round(cars);
    }
}
