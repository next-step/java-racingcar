package edu.nextstep.racing.model;

import edu.nextstep.racing.utils.ValidationUtils;

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
        // 각각의 자동차의 이름이 null or "" 인지 체크하는 로직
        validateCarName(cars);

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

    private void validateCarName(List<String> carName) {
        for (String s : carName) {
            ValidationUtils.checkObject(s);
        }
    }
}
