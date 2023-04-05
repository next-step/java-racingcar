package racingcar.domain;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void racingStart() {
        for (Car car : cars) {
            car.move();
        }
    }

}
