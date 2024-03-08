package racinggame.domain;

import racinggame.domain.MoveCondition;

public class AlwaysMoveCondition extends MoveCondition {

    @Override
    public boolean isMovable() {
        return true;
    }
}
