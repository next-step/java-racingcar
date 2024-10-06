package racingcar.refactoring.domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }
}
