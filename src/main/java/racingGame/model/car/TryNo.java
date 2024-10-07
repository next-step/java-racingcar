package racingGame.model.car;

public class TryNo {

    private static final int MINIMUM_MOVE_COUNT = 1;

    private static final String MOVE_COUNT_ERROR_MESSAGE = "최소 1회 이상은 입력해주세요!";

    private int tryNo;

    public TryNo(int tryNo) {
        validateMoveCount(tryNo);
        this.tryNo = tryNo;
    }

    public int getTryNo() {
        return this.tryNo;
    }

    private void validateMoveCount(int tryNo) {
        if (tryNo < MINIMUM_MOVE_COUNT) {
            throw new IllegalArgumentException(MOVE_COUNT_ERROR_MESSAGE);
        }
    }
}
