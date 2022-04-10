package racingcar.model;

import racingcar.commons.Constant;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsProgress {

    private List<Cars> carsList;

    public CarsProgress(int numberOfCars) {
        carsList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            Cars cars = new Cars();
            cars.setDistanceTraveled(Constant.MOVEMENT_DISTANCE_INITIAL_VALUE);
            carsList.add(cars);
        }
    }

    public List<Cars> getCarsList() {
        return carsList;
    }

    public void changeDistanceByCar(Cars cars, int determinationValue) {
        if (determinationValue >= Constant.RANDOM_MINIMUM_VALUE_CAN_BE_MOVED) {
            cars.setDistanceTraveled(cars.getDistanceTraveled() + 1);
        }
    }
}
