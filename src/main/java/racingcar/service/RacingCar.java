package racingcar.service;

import java.util.ArrayList;

import java.util.List;

public class RacingCar {

    private final List<Car> cars;
    private CarControl carControl;

    public RacingCar(int numberOfCars) {
        this.cars = registerCar(numberOfCars);
        this.carControl = new CarControl();
    }

    private List<Car> registerCar(int numberOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public void start() {
        cars.stream().forEach(car -> goOrStop(car));
    }

    private void goOrStop(Car car) {
        if (carControl.goOrStop()) {
            car.drive();
        }
    }

    public int[] getStatusOfCars() {
        return cars.stream().mapToInt(i -> i.getDistance()).toArray();
    }
}
