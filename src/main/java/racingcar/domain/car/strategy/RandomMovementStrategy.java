package racingcar.domain.car.strategy;

public class RandomMovementStrategy implements MovementStrategy {
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.generate() >= MOVE_CONDITION;
    }
}
