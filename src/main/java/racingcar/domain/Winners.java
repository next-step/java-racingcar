package racingcar.domain;

import java.util.List;

public class Winners {

    private List<Car> cars;

    private Winners(List<Car> cars) {
        this.cars = cars;
    }

    public static Winners valueOf(List<Car> cars) {
        return new Winners(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
