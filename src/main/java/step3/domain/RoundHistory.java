package step3.domain;

import java.util.List;

public class RoundHistory {
    private Cars cars;

    private RoundHistory() {}

    public RoundHistory(Cars cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return cars.getCars();
    }

    public int getMaxPosition() {
        return cars.getMaxPosition();
    }
}
