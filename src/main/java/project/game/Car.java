package project.game;

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

    public boolean canBeWinner(int winnerScore) {
        return mMovePosition == winnerScore;
    }

    private boolean canMove() {
        return mMoveRule.canMove();
    }
}
