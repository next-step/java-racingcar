package racingcar.domain.car.strategy;

public class FixedMovementStrategy implements MovementStrategy {
    private boolean movable;

    public FixedMovementStrategy() {
        this.movable = false;
    }

    @Override
    public boolean isMovable() {
        movable = !movable;
        return movable;
    }
}
