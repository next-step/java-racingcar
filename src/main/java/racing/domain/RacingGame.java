package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.startegy.MovingStrategy;

public class RacingGame {

    private final MovingStrategy movingStrategy;
    private final Cars cars;

    public RacingGame(MovingStrategy movingStrategy, List<Car> cars) {
        this.movingStrategy = movingStrategy;
        this.cars = new Cars(cars);
    }

    public static RacingGame registerCars(MovingStrategy movingStrategy, List<String> names) {
        final List<Car> cars = names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        return new RacingGame(movingStrategy, cars);
    }

    public List<Cars> race(final TryNumber tryNumber) {
        final List<Cars> raceStates = new ArrayList<>();
        while (tryNumber.hasNextStep()) {
            raceStates.add(new Cars(this.cars.driveCars(movingStrategy)));
            tryNumber.nextStep();
        }
        return raceStates;
    }

    public List<Car> getWinners() {
        return cars.decideWinners();
    }
}
