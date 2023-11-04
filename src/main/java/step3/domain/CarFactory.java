package step3.domain;

import step3.validite.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private List<Car> cars;
    private RandomNumber randomNumber;

    public CarFactory() {
        this.cars = new ArrayList<>();
        randomNumber = new RandomNumber();
    }

    public List<Car> carsInfo() {
        return cars;
    }

    public void participants(int count) {
        for (int addCar = 0; addCar < count; addCar++) {
            cars.add(new Car());
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(randomNumber.randomNumberCreate());
        }
    }

}
