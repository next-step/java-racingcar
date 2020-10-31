package step4.domain;

import step4.exception.OutBoundCarListSizeException;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int CARS_MIN_COUNT = 1;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateSize(cars);
        this.cars = cars;
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < CARS_MIN_COUNT) {
            throw new OutBoundCarListSizeException();
        }
    }

    public void moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Integer> getCarsPosition() {
        return cars.stream()
                .map(Car::getCarPosition)
                .collect(Collectors.toList());
    }

}
