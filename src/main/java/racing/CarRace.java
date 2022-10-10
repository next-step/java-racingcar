package racing;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private final List<Car> cars;
    private static final CarMovingStrategy DEFAULT_STRATEGY = new RandomCarMovingStrategy();

    public CarRace(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("car is empty");
        }
        this.cars = cars;
    }

    public void round() {
        round(DEFAULT_STRATEGY);
    }

    public void round(CarMovingStrategy movingStrategy) {
        cars.forEach(car -> car.tryMove(movingStrategy));
    }

    public List<Car> getWinners() {
        return getWinners(cars);
    }

    static List<Car> getWinners(List<Car> cars) {
        int maxMoves = cars.stream().mapToInt(Car::getMoves).max().orElseThrow();
        return cars.stream().filter(car -> car.getMoves() == maxMoves).collect(Collectors.toList());
    }
}
