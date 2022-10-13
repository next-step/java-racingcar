package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private static final CarMovingStrategy DEFAULT_STRATEGY = new RandomCarMovingStrategy();

    private final List<Car> cars;

    public CarRace(String[] names) {
        this(toCars(names));
    }

    public CarRace(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("car is empty");
        }
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void round() {
        round(DEFAULT_STRATEGY);
    }

    public void round(CarMovingStrategy movingStrategy) {
        cars.forEach(car -> car.tryMove(movingStrategy));
    }

    public List<Car> getWinners() {
        CarDistance maxDistance = cars.stream()
            .map(Car::getDistance)
            .max(CarDistance::compareTo)
            .orElseThrow();

        return cars.stream()
                .filter(car -> car.hasDistance(maxDistance))
                .collect(Collectors.toList());
    }

    private static List<Car> toCars(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
