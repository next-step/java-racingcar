package model;

import exception.NotEnoughCarsException;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars == null || cars.size() <= 0) {
            throw new NotEnoughCarsException("0대 이상의 차가 필요합니다.");
        }

        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
