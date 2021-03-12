package RacingCarTest;

import racingcar.domain.MovementCondition;

public class AlwaysMoveCondition implements MovementCondition {
    @Override
    public boolean isMovable() {
        return true;
    }
}
