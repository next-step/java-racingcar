package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void updateEveryCarByCondition() {
        for (Car car : cars) {
            car.updatePositionByCondition(NumberGenerator.generator());
        }
    }
}
