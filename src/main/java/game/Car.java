package game;

public class Car {

    private MoveRule mMoveRule;

    public Car(MoveRule moveRule) {
        mMoveRule = moveRule;
    }

    public boolean canMove() {
        return mMoveRule.canMove();
    }
}
