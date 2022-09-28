package racingcar;

import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = createCars(carNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> createCars(String[] carNames) {
        final List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
        return cars;
    }

    public List<Car> findMaxPositionCars() {
        Position maxPosition = findMaxPosition();

        List<Car> maxPositionCars = new ArrayList<>();
        for (Car car : cars) {
            addToCarListIfPositionEquals(car, maxPosition, maxPositionCars);
        }
        return maxPositionCars;
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.getPosition().getBigger(maxPosition);
        }
        return maxPosition;
    }

    private void addToCarListIfPositionEquals(Car car, Position maxPosition, List<Car> maxPositionCars) {
        if (car.isPositionEquals(maxPosition)) {
            maxPositionCars.add(car);
        }
    }
}
