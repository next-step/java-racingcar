package racinggame.mvc.domain;

public final class RemainingRounds {

    private int rounds;

    public RemainingRounds(int rounds) {
        if (rounds < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        this.rounds = rounds;
    }

    public boolean isExhausted() {
        return rounds == 0;
    }

    public void ensureAvailable() {
        if (isExhausted()) {
            throw new IllegalStateException("시도 횟수를 초과했습니다.");
        }
    }

    public void decrease() {
        ensureAvailable();
        rounds--;
    }
}
