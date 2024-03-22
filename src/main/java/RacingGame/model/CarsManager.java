package RacingGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarsManager {
    private final List<Car> cars;

    public CarsManager() {
        this(new ArrayList<Car>());
    }

    public CarsManager(List<Car> cars) {
        this.cars = cars;
    }

    public static CarsManager withCarCount(int carCount) {
        List<Car> cars = IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());

        return new CarsManager(cars);
    }

    public static CarsManager withCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(carname -> new Car(carname))
                .collect(Collectors.toList());

        return new CarsManager(cars);
    }

    public void tryMoveCars(MovableStrategy movableStrategy) {
        cars.forEach(car -> car.move(movableStrategy));
    }

    public List<Integer> getCarsPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public List<Car> winners() {
        int highestPosition = findHighestPosition();

        return this.cars.stream()
                .filter(car -> car.isPositionAt(highestPosition))
                .collect(Collectors.toList());
    }

    private int findHighestPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<String> winnerNames() {
        return winners().stream()
                .map(Car::name).collect(Collectors.toList());
    }

    public Map<String, Integer> carNamePositions() {
        return cars.stream()
                .collect(Collectors.toMap(Car::name, Car::getPosition));
    }
}
