package step3;

import step3.car.Car;
import step3.car.CarController;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private final List<Car> cars;
    private final CarController carController;

    public Round(CarController carController) {
        this.carController = carController;
        this.cars = new ArrayList<>();
    }

    public void init(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public void start() {
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            carController.moveCar(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
