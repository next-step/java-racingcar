package step3.domain;

import step3.validite.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private List<Car> cars;

    public CarFactory() {
        this.cars = new ArrayList<>();
    }

    public List<Car> carsInfo() {
        return cars;
    }

    public void participants(int count) {
        for (int addCar = 0; addCar < count; addCar++) {
            cars.add(new Car());
        }
    }
}
