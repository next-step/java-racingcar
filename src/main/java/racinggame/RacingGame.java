package racinggame;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public int carsCount() {
        return this.cars.size();
    }
}
