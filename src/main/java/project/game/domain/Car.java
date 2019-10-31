package project.game.domain;

public class Car {

    private static final int START_POSITION = 1;

    private String mName;
    private MoveRule mMoveRule;
    private int mMovePosition = START_POSITION;

    public Car(String name, MoveRule moveRule) {
        mName = name;
        mMoveRule = moveRule;
    }

    public int moveIfPossible() {
        if (canMove()) {
            mMovePosition++;
        }

        return mMovePosition;
    }

    public boolean hasEqualPositionTo(int targetPosition) {
        return mMovePosition == targetPosition;
    }

    public String getName() {
        return mName;
    }

    private boolean canMove() {
        return mMoveRule.canMove();
    }
}
