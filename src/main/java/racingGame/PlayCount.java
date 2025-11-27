package racingGame;

public class PlayCount {

    private static final PlayCount ZERO = new PlayCount(0);

    private final int value;

    private PlayCount(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("플레이 횟수는 음수가 될 수 없습니다: " + value);
        }
        this.value = value;
    }

    public static PlayCount zero() {
        return ZERO;
    }

    public PlayCount increase() {
        return new PlayCount(value + 1);
    }

    public boolean isLessThan(TryNumber tryNumber) {
        return tryNumber.isGreaterThan(value);
    }
}
