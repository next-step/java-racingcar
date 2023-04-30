package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars = new ArrayList<>();

    public static RacingCars create(List<Car> cars) {
        RacingCars racingCars = new RacingCars();
        racingCars.cars.addAll(cars);
        return racingCars;
    }

    public void moveCars(IMovingStrategy movingStrategy) {
        for (Car car : this.cars) {
            moveCar(car, movingStrategy);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Position getFarthestPosition() {
        Position farthestPosition = new Position(0);
        for (Car car : cars) {
            farthestPosition = car.getFarthestPosition(farthestPosition);
        }
        return farthestPosition;
    }

    public List<Car> winnerCars() {
        return this.cars.stream()
                .filter(car -> car.isSamePosition(getFarthestPosition()))
                .collect(Collectors.toList());
    }

    private void moveCar(Car car, IMovingStrategy movingStrategy) {
        car.go(movingStrategy);
    }

}
