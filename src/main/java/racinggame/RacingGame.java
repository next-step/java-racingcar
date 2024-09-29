package racinggame;

public class RacingGame {

    private int round;

    public RacingGame() {
        this.round = 1;
    }

    public int getRound() {
        return round;
    }

    public void start(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            validateNextRound(tryCount);
        }
    }

    private void validateNextRound(int tryCount) {
        if (isNextRound(tryCount)) {
            round++;
        }
    }

    private boolean isNextRound(int tryCount) {
        return round < tryCount;
    }
}
