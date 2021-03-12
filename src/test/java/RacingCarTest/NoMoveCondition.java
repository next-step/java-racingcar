package RacingCarTest;

import racingcar.domain.MovementCondition;

public class NoMoveCondition implements MovementCondition {
    @Override
    public boolean isMovable() {
        return false;
    }
}
