package step3.domain;

import java.util.List;

public class GameInfo {

    private final Cars cars;
    private final int count;

    public GameInfo(Cars cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public List<Car> getCarList() {
        return cars.getCarList();
    }

    public int getCount() {
        return count;
    }
}
