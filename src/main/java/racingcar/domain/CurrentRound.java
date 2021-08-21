package racingcar.domain;

public class CurrentRound {
    private static final int MIN_CURRENT_ROUND = 0;
    private final int currentRound;

    public CurrentRound(int currentRound) {
        checkValidCurrentRound(currentRound);
        this.currentRound = currentRound;
    }

    public CurrentRound() {
        this(MIN_CURRENT_ROUND);
    }

    void checkValidCurrentRound(int currentRound) {
        if (currentRound < MIN_CURRENT_ROUND) {
            throw new IllegalArgumentException("유효한 Current Round가 아닙니다.");
        }
    }

    CurrentRound runOneRound() {
        return new CurrentRound(currentRound + 1);
    }

    public String toString() {
        return "< Round " + currentRound + " >";
    }
}
