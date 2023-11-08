package carracing;

import carracing.move_strategy.MoveStrategy;
import carracing.move_strategy.RandomMoveStopStrategy;

import java.util.List;

public class Track {
    private static final MoveStrategy moveStrategy = new RandomMoveStopStrategy();
    private final Cars cars;

    public Track(Cars cars) {
        this.cars = cars;
    }

    public void run() {
        cars.move(moveStrategy);
    }

    public List<Car> winners() {
        return cars.getFastestCars();
    }

    public Cars carHistory() {
        return this.cars;
    }
}
