package study.racing.domain;

public class Round {
    private static final int MIN_ROUND = 1;
    private int remaining;

    public Round(int totalRound) {
        validate(totalRound);
        this.remaining = totalRound;
    }

    private void validate(int totalRound) {
        if (totalRound < MIN_ROUND) {
            throw new IllegalArgumentException("라운드는 1이상어야 한다.");
        }
    }

    public void decrease() {
        if (!hasRemaining()) {
            throw new IllegalStateException("진행할 라운드가 없습니다.");
        }
        remaining--;
    }

    public boolean hasRemaining() {
        return remaining > 0;
    }

    public int getRemaining() {
        return remaining;
    }
}
