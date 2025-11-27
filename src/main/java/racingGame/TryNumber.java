package racingGame;

public class TryNumber {

    private final int value;

    public TryNumber(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다: " + value);
        }
        this.value = value;
    }

    public boolean canPlayMore(int playedCount) {
        return playedCount < value;
    }
}
