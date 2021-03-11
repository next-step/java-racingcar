package RacingCarTest;

import racingcar.MovementCondition;

public class AlwaysMoveCondition implements MovementCondition {
    @Override
    public boolean isMovable() {
        return true;
    }
}
