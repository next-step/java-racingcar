package racinggame.domain;

public class NeverMoveCondition extends MoveCondition {

    @Override
    public boolean isMovable() {
        return false;
    }
}
