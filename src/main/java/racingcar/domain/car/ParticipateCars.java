package racingcar.domain.car;

import racingcar.domain.car.strategy.MovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipateCars {
    private List<Car> cars;

    public ParticipateCars(String[] nameOfCars) {
        this.cars = createCars(nameOfCars);
    }

    private List<Car> createCars(int numberOfCar) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    private List<Car> createCars(String[] nameOfCars) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < nameOfCars.length; i++) {
            cars.add(new Car(nameOfCars[i]));
        }

        return cars;
    }

    public List<CarMoveResult> moveCars(MovementStrategy movementStrategy) {
        List<CarMoveResult> carMoveResults = new ArrayList<>();

        for (Car car : cars) {
            int afterLocation = car.move(movementStrategy);
            carMoveResults.add(new CarMoveResult(car.getName(), afterLocation));
        }

        return carMoveResults;
    }
}
