package edu.nextstep.racing.model;

import java.util.ArrayList;
import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 19:12
 */
public class Cars {
    private List<Car> cars;

    public Cars(List<String> cars) {
        this.cars = new ArrayList<>();
        convertStringToCar(cars);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    private void convertStringToCar(List<String> cars) {
        for (String carName : cars) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }
}
