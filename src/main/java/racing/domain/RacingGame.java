package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.car.Position;
import racing.domain.startegy.MovingStrategy;
import racing.domain.startegy.RandomMovingStrategy;

public class RacingGame {

    private final MovingStrategy movingStrategy;
    private final Cars cars;

    private RacingGame(MovingStrategy movingStrategy, Cars cars) {
        this.movingStrategy = movingStrategy;
        this.cars = cars;
    }

    public RacingGame(MovingStrategy movingStrategy, List<Car> cars) {
        this.movingStrategy = movingStrategy;
        this.cars = new Cars(cars);
    }

    public static RacingGame registerCars(MovingStrategy movingStrategy, List<String> names) {
        return new RacingGame(movingStrategy, new Cars(names, 0));
    }

    public List<Cars> race(final TryNumber tryNumber) {
        final List<Cars> raceStates = new ArrayList<>();
        while (tryNumber.hasNextStep()) {
            raceStates.add(new Cars(this.cars.driveCars(movingStrategy)));
            tryNumber.nextStep();
        }
        return raceStates;
    }

    public List<Car> decideWinners() {
        final Position maxPosition = cars.findMaxPosition();
        return cars.getCars().stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList());
    }
}
