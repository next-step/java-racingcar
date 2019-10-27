package game;

public abstract class Car {

    private MoveRule mMoveRule;

    public Car() {
        mMoveRule = getMoveRule();
    }

    public boolean canMove() {
        return mMoveRule.canMove();
    }

    protected abstract MoveRule getMoveRule();
}
