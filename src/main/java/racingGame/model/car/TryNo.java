package racingGame.model.car;

public class TryNo {

    private static final int MINIMUM_MOVE_COUNT = 1;

    private static final String MOVE_COUNT_ERROR_MESSAGE = "최소 1회 이상은 입력해주세요!";

    private int round;

    public TryNo(int tryNo) {
        validateMoveCount(tryNo);
        this.round = tryNo;
    }

    public void forEach(Runnable runnable) {
        for(int i = 0; i< this.round; i++) {
            runnable.run();
        }
    }

    public int getTryNo() {
        return this.round;
    }

    private void validateMoveCount(int tryNo) {
        if (tryNo < MINIMUM_MOVE_COUNT) {
            throw new IllegalArgumentException(MOVE_COUNT_ERROR_MESSAGE);
        }
    }
}
