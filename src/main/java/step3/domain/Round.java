package step3.domain;

public class Round {
    private int roundsCount;

    public Round(int roundsCount) {
        this.roundsCount = roundsCount;
    }

    public boolean isRoundContinue() {
        return this.roundsCount > 0;
    }

    public void reduceRound() {
        this.roundsCount--;
    }
}
