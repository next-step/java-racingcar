package racing.domain;

import java.util.List;

public class Result {
    private final Cars cars;

    public Result(Cars cars) throws CloneNotSupportedException {
        this.cars = cars.clone();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public Cars getCars() {
        return cars;
    }
}
