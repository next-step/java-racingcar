package racinggame.winner;

public class RacingCount {

    private int count;

    public RacingCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        this.count = count;
    }

    public void decrease() {
        if (isZero()) {
            throw new IllegalStateException("시도 횟수를 초과했습니다.");
        }
        count--;
    }

    public boolean isZero() {
        return count == 0;
    }

    public static RacingCount withinLimit(int count, int maxCount) {
        if (count > maxCount) {
            throw new IllegalArgumentException("시도 횟수는 " + maxCount + " 이하이어야 합니다.");
        }

        return new RacingCount(count);
    }
}
