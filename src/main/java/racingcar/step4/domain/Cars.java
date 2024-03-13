package racingcar.step4.domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> copyCars() {
        return List.copyOf(cars);
    }
}
