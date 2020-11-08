package racingcar.utils;

import racingcar.Car;

public class CarsGenerator {
    public Car[] generateCars(int countOfCar) {
        Car[] cars = new Car[countOfCar];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
        return cars;
    }
}
