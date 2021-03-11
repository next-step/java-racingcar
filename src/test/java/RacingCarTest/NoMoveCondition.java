package RacingCarTest;

import racingcar.MovementCondition;

public class NoMoveCondition implements MovementCondition {
    @Override
    public boolean isMovable() {
        return false;
    }
}
