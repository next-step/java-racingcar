package RacingCarTest;

import RacingCar.MovementCondition;

public class NoMoveCondition implements MovementCondition {
    @Override
    public boolean isMovable() {
        return false;
    }
}
