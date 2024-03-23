package racing.domain;

import java.util.List;

public class Winners {

    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> winners() {
        return this.cars;
    }
}
