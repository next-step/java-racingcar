package racing;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private final List<Car> cars;

    public CarRace(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("car is empty");
        }
        this.cars = cars;
    }

    public void round() {
        cars.forEach(Car::tryMove);
    }

    public List<Car> getWinners() {
        int maxMoves = cars.stream().mapToInt(Car::getMoves).max().orElseThrow();
        return cars.stream().filter(car -> car.getMoves() == maxMoves).collect(Collectors.toList());
    }
}
