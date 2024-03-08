package racinggame;

import racinggame.domain.MoveCondition;

public class AlwaysMoveCondition extends MoveCondition {

    @Override
    public boolean isMovable() {
        return true;
    }
}
