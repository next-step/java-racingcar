package racinggame.domain;

import racinggame.domain.MoveCondition;

public class NeverMoveCondition extends MoveCondition {

    @Override
    public boolean isMovable() {
        return false;
    }
}
