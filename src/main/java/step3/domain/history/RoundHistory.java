package step3.domain.history;

import step3.domain.Car;
import step3.domain.Cars;

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
