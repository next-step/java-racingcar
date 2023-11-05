package carracing;

import carracing.move_strategy.MoveStrategy;
import carracing.move_strategy.RandomMoveStopStrategy;

import static carracing.Cars.makeCars;

public class Track {

    private static final MoveStrategy moveStrategy = new RandomMoveStopStrategy();
    private final Cars cars;
    private final int movingCount;
    private final TrackHistory trackHistory = new TrackHistory();

    public Track(int carCount, int movingCount) {
        cars = makeCars(carCount, moveStrategy);
        this.movingCount = movingCount;
    }

    public void run() {
        for (int i = 0; i < movingCount; i++) {
            cars.move();
            trackHistory.add(cars);
        }
    }

    public TrackHistory getTrackHistory() {
        return this.trackHistory;
    }
}
