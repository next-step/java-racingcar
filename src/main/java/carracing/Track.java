package carracing;

import carracing.move_strategy.MoveStrategy;
import carracing.move_strategy.RandomMoveStopStrategy;

import static carracing.Cars.makeCars;

public class Track {
    private static final MoveStrategy moveStrategy = new RandomMoveStopStrategy();
    private final Cars cars;

    public Track(int carCount) {
        cars = makeCars(carCount, moveStrategy);
    }

    public void run() {
        cars.move();
    }

    public Cars carHistory() {
        return this.cars;
    }
}
