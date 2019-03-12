package racingcar.vo;

public class RacingGameRound {
    private int totalRound;
    private int currentRound;

    public RacingGameRound(int totalRound) {
        this(totalRound, 1);
    }

    public RacingGameRound(int totalRound, int currentRound) {
        this.totalRound = totalRound;
        this.currentRound = currentRound;
    }

    public int getTotalRound() {
        return totalRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
