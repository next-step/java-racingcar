package step3.study.domain;

import step3.study.util.RacingUtil;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(RacingUtil.createRandomNumber());
        }
    }
}
