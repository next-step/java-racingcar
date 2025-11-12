package racingcar.domain;

public class Round {
    private static final int MIN_ROUND = 1;
    private static final int START_ROUND = 1;
    private static final int ROUND_STEP = 1;

    private final int maxRound;
    private int currentRound;

    public Round(int maxRound) {
        validate(maxRound);
        this.maxRound = maxRound;
        this.currentRound = START_ROUND;
    }

    private void validate(int value) {
        if (value < MIN_ROUND) {
            throw new IllegalArgumentException("최대 라운드 수는 1이상이어야 합니다.");
        }
    }

    public void next() {
        this.currentRound += ROUND_STEP;
    }

    public boolean isFinished() {
        return this.currentRound > maxRound;
    }

    public int getCurrentRound() {
        return this.currentRound;
    }
}
