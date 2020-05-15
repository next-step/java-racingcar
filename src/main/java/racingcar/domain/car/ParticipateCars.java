package racingcar.domain.car;

import racingcar.domain.car.strategy.MovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipateCars {
    private List<Car> cars;

    public ParticipateCars(int numberOfCar) {
        this.cars = createCars(numberOfCar);
    }

    private List<Car> createCars(int numberOfCar) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public List<Integer> moveCars(MovementStrategy movementStrategy) {
        return this.cars.stream()
                .map(car -> car.move(movementStrategy))
                .collect(Collectors.toList());
    }
}
