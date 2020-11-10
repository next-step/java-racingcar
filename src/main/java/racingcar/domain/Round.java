package racingcar.domain;

public class Round {
    private int round;
    private final int finalRound;

    public Round(int finalRound) {
        this.finalRound = finalRound;
    }

    public void nextRound() {
        round = round + 1;
    }

    public boolean isLastRound() {
        return finalRound == round;
    }
}
