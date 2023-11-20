package racingCar.domain;

public class RacingManager {
    private final CarGroup carGroup;
    private final TryCount tryCount;
    private final MovementGenerator movementGenerator;

    public RacingManager(CarGroup carGroup, TryCount tryCount, MovementGenerator movementGenerator) {
        this.carGroup = carGroup;
        this.tryCount = tryCount;
        this.movementGenerator = movementGenerator;
    }

    public boolean canPlay() {
        return !tryCount.isMaxCount();
    }

    public void playTurn() {
        carGroup.move(movementGenerator);
        tryCount.increaseCount();
    }
}
