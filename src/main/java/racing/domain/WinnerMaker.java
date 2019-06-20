package racing.domain;

import java.util.List;

public class WinnerMaker {
    private Cars cars;

    public WinnerMaker(Cars cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        int max = cars.findMaxPosition();

        return cars.findCarsInPosition(max);
    }
}
