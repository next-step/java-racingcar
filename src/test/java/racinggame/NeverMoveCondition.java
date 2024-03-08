package racinggame;

public class NeverMoveCondition extends MoveCondition{

    @Override
    public boolean isMovable() {
        return false;
    }
}
