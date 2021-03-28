package step03Refactor;

public class RoundCount {

    private int totalRoundCount;
    private int currentRoundCount;

    RoundCount(final int totalRoundCount) {
        this.totalRoundCount = totalRoundCount;
    }

    public boolean isFinishRound() {
        if (totalRoundCount > currentRoundCount) {
            currentRoundCount++;
            return false;
        }
        return true;
    }
}
