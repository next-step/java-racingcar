package racing.domain;

import java.util.List;

public class RoundResult {

    private final List<Car> cars;

    public RoundResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
