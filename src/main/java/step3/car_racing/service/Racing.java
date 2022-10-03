package step3.car_racing.service;

import step3.car_racing.model.Car;
import step3.car_racing.model.Cars;
import step3.car_racing.view.InputView;

public class Racing {

    public Cars race(InputView input) {

        Cars cars = new Cars().makeCarList(input.inputCarSize());

        for (int i = 0; i < input.inputRacingSize(); i++) {
            cars.getCarList().forEach(Car::moveForward);
            System.out.println();
        }

        return cars;
    }

}
