package racingcar.service;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCar {

    private final List<Car> cars;
    private CarControl carControl;

    public RacingCar(String numberOfCars) {
        this.cars = registerCar(numberOfCars);
        this.carControl = new CarControl();
    }

    private List<Car> registerCar(String numberOfCar) {
        return null;
//        return IntStream.range(0, numberOfCar).mapToObj(i -> new Car()).collect(Collectors.toList());
    }

    public void start() {
        cars.forEach(car -> goOrStop(car));
    }

    private void goOrStop(Car car) {
        if (carControl.goOrStop()) {
            car.drive();
        }
    }

    public int[] getStatusOfCars() {
        return cars.stream().mapToInt(Car::getDistance).toArray();
    }
}
