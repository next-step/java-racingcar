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
                .map(Car::new)
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

    public Map<String, Integer> carNamePositions() {
        return cars.stream()
                .collect(Collectors.toMap(Car::name, Car::getPosition));
    }
}
