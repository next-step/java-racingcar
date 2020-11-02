package step4.domain;

import step4.exception.OutBoundCarListSizeException;

import java.util.List;

public class Cars {
    private static final int CARS_MIN_COUNT = 1;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarSize(cars);
        this.cars = cars;
    }


    public void moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getCarsStatus() {
        return cars;
    }

    private void validateCarSize(List<Car> cars) {
        if (cars.size() < CARS_MIN_COUNT) {
            throw new OutBoundCarListSizeException(CARS_MIN_COUNT);
        }
    }
}
