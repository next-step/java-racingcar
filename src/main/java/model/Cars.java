package model;

import constant.ErrorMessage;
import exception.NotEnoughCarsException;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars == null || cars.size() <= 0) {
            throw new NotEnoughCarsException(ErrorMessage.NOT_ENOUGH_CAR);
        }

        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
