package carracing;

import carracing.move_strategy.MoveStrategy;
import carracing.move_strategy.RandomMoveStopStrategy;

import java.util.List;

import static carracing.Cars.makeCars;

public class Track {
    private static final MoveStrategy moveStrategy = new RandomMoveStopStrategy();
    private final Cars cars;

    public Track(List<String> carNames) {
        cars = makeCars(carNames, moveStrategy);
    }

    public void run() {
        cars.move();
    }

    public Cars carHistory() {
        return this.cars;
    }
}
