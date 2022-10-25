package racingcar.race;

public class RacingModel {
    protected static final int MOVE_POSSIBLE = 4;
    private final int ZERO = 0;
    private int tryCount;

    public RacingModel(int tryCount) {
        if (tryCount < ZERO) {
            throw new RuntimeException("0보다 큰 수를 입력하세요");
        }
        this.tryCount = tryCount;
    }

    public static boolean isMovePossible(int number) {
        if (number >= MOVE_POSSIBLE) {
            return true;
        }
        return false;
    }

    public int getTryCount() {
        return tryCount;
    }
}
