package racinggame;

import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Race(List<String> carNames, MoveStrategy moveStrategy) {
        this.cars = createCars(carNames);
        this.moveStrategy = moveStrategy;
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void run(int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        cars.forEach(car -> car.move(moveStrategy));
    }
}
