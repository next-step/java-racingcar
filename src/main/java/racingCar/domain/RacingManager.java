package racingCar.domain;

public class RacingManager {
    private final Cars cars;
    private final TryCount tryCount;
    private final MovementGenerator movementGenerator;

    public RacingManager(Cars cars, TryCount tryCount, MovementGenerator movementGenerator) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.movementGenerator = movementGenerator;
    }

    public boolean canPlay() {
        return !tryCount.isMaxCount();
    }

    public void playTurn() {
        cars.move(movementGenerator);
        tryCount.increaseCount();
    }
}
