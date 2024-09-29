package step3;

import step3.car.Car;
import step3.car.CarController;

import java.util.List;

public class Round {
    private final List<Car> cars;
    private final CarController carController;

    public Round(List<Car> cars, CarController carController) {
        this.cars = cars;
        this.carController = carController;
    }

    public void start() {
        for (Car car : cars) {
            carController.moveCar(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
