package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.car.Position;

public class RacingGame {

    private static final String COMMA = ", ";

    private final List<List<Car>> raceStates = new ArrayList<>();
    private Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public static RacingGame registerCars(List<String> names) {
        return new RacingGame(new Cars(names, 0));
    }

    public void race(final TryNumber tryNumber) {
        while (tryNumber.hasNextStep()) {
            raceStates.add(cars.driveCars());
            tryNumber.nextStep();
        }
    }

    public List<List<Car>> raceResult() {
        return new ArrayList(new ArrayList(raceStates));
    }

    public String decideWinners() {
        return cars.getCars().stream()
            .filter(car -> car.isSamePosition(new Position(cars.getMaxPosition())))
            .map(Car::getNameValue)
            .collect(Collectors.joining(COMMA));
    }
}
