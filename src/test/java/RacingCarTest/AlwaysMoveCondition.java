package RacingCarTest;

import RacingCar.MovementCondition;

public class AlwaysMoveCondition implements MovementCondition {
    @Override
    public boolean isMovable() {
        return true;
    }
}
