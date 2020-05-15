package racinggame.domain.car;

import racinggame.domain.Engine;
import racinggame.domain.result.RacingGameSnapshot;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(final List<String> participantCars) {
        this.cars = createInitialCar(participantCars);
    }

    public RacingGameSnapshot race(Engine engine) {
        return cars.stream()
                .map(car -> car.move(engine))
                .collect(collectingAndThen(toList(), RacingGameSnapshot::new));
    }

    private List<Car> createInitialCar(List<String> participantCars) {
        return participantCars.stream()
                .map(Car::new)
                .collect(toList());
    }
}
