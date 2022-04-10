package racingcar.model;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsProgress {
    public static final int RANDOM_MINIMUM_VALUE_CAN_BE_MOVED = 4;

    private List<Car> carsList;

    public CarsProgress(int numberOfCars) {
        carsList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            Car car = new Car();
            carsList.add(car);
        }
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public void changeDistanceByCar(Car car, int determinationValue) {
        if (determinationValue >= RANDOM_MINIMUM_VALUE_CAN_BE_MOVED) {
            car.changeDistance();
        }
    }
}
