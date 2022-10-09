package racing.domain;

import racing.domain.car.Car;
import racing.domain.movingstrategy.MovingStrategy;

import java.util.List;

public class RacingGame {

    private final CarGroup carGroup;
    private final MovingStrategy movingStrategy;
    private Attempts attempts;

    public RacingGame(List<Car> cars, int numberOfAttempts, MovingStrategy movingStrategy) {
        this.carGroup = new CarGroup(cars);
        this.movingStrategy = movingStrategy;
        this.attempts = new Attempts(numberOfAttempts);
    }

    public CarGroup runRound() {
        attempts = attempts.run();
        return carGroup.moveAll(movingStrategy);
    }

    public List<Car> winner() {
        return carGroup.leadingGroup();
    }

    public boolean isRunning() {
        return attempts.isRemain();
    }
}
