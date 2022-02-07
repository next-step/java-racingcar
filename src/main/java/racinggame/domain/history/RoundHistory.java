package racinggame.domain.history;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.car.Car;

public class RoundHistory {

    private final List<Car> cars;

    public RoundHistory(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getRoundHistory() {
        return new ArrayList<>(cars);
    }
}
