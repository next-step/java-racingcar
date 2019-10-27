package game;

public class Car {

    private static final int START_POSITION = 1;

    private MoveRule mMoveRule;
    private int mMovePosition = START_POSITION;

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
