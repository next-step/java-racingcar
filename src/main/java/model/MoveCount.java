package model;

public class MoveCount {
    private static final String LESS_THAN_ZERO_ERROR_MESSAGE = "1이상의 이동횟수를 입력해야됩니다.";
    private static final String CAN_NOT_MOVE_LESS_THAN_ZERO = "움직일 수 없는 상태입니다.";

    private static final int DONE_MOVE_COUNT = 0;

    private int moveCount;

    public MoveCount(int moveCount) {
        int ZERO_NUMBER = 0;

        if (moveCount <= ZERO_NUMBER) {
            throw new IllegalStateException(LESS_THAN_ZERO_ERROR_MESSAGE);
        }

        this.moveCount = moveCount;
    }

    public void decreaseMoveCount() {
        if (this.moveCount <= 0) {
            throw new IllegalStateException(CAN_NOT_MOVE_LESS_THAN_ZERO);
        }
        this.moveCount--;
    }

    public boolean isDone() {
        return moveCount <= DONE_MOVE_COUNT;
    }
}
