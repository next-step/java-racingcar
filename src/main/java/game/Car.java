package game;

public class Car {

    private MoveRule mMoveRule;
    private int mMovePosition = 0;

    public Car(MoveRule moveRule) {
        mMoveRule = moveRule;
    }

    public int moveIfPossible() {
        if (canMove()) {
            mMovePosition++;
        }

        return mMovePosition;
    }

    private boolean canMove() {
        return mMoveRule.canMove();
    }
}
