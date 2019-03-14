package racingcar.vo;

public class RacingGameRound {
    private static final int FIRST_ROUND = 1;

    private int totalRound;
    private int currentRound;

    public RacingGameRound(int totalRound) {
        this(totalRound, FIRST_ROUND);
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
