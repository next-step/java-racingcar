package racinggame.mvc.domain;

public final class RemainingRounds {

    private static final int MIN_ROUNDS = 1;

    private int rounds;

    public RemainingRounds(int rounds) {
        validateInitialRounds(rounds);
        this.rounds = rounds;
    }

    private void validateInitialRounds(int rounds) {
        if (rounds < MIN_ROUNDS) {
            throw new IllegalArgumentException("시도 횟수는 " + MIN_ROUNDS + " 이상이어야 합니다.");
        }
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
