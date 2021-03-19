package step4.domain;

public class Round {
    private int roundCount;

    private Round(final int roundCount) {
        this.roundCount = roundCount;
    }

    public static Round from(final int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0보다 큰값을 입력해야 합니다.");
        }
        return new Round(roundCount);
    }

    public boolean isMovable() {
        roundCount--;
        return roundCount >= 0;
    }
}
