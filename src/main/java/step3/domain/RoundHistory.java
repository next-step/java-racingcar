package step3.domain;

import java.util.List;

public class RoundHistory {
    private Cars cars;

    private RoundHistory() {}

    private RoundHistory(Cars cars) {
        this.cars = cars;
    }

    public static RoundHistory of(Cars cars) {
        return new RoundHistory(cars);
    }

    public List<Car> getCarList() {
        return cars.getCars();
    }

    public int getMaxPosition() {
        return cars.getMaxPosition();
    }
}
