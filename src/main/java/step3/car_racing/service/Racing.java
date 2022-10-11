package step3.car_racing.service;

import step3.car_racing.model.Car;
import step3.car_racing.model.Cars;

public class Racing {

    public Cars race(int carSize, int racingCount) {

        Cars cars = new Cars().makeCarList(carSize);

        for (int i = 0; i < racingCount; i++) {
            cars.getCarList().forEach(Car::moveForward);
            System.out.println();
        }

        return cars;
    }

}
