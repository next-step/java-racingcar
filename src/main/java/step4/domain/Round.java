package step4.domain;

public class Round {
    private static final int ZERO = 0;

    private int count;

    private Round(final int count) {
        this.count = count;
    }

    public static Round from(final int count) {
        if (count <= ZERO) {
            throw new IllegalArgumentException("시도할 횟수는 0보다 큰값을 입력해야 합니다.");
        }
        return new Round(count);
    }

    public boolean isMovable() {
        return count > ZERO;
    }

    public void minusCount() {
        count--;
    }
}
