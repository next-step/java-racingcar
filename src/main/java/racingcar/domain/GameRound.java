package racingcar.domain;

public class GameRound {

    private int totalRound;
    private int currentRound;

    public GameRound(int totalRound) {
        this.totalRound = totalRound;
    }

    public void roundFinish() {
        this.currentRound++;
    }

    public boolean isAllRoundFinish() {
        return currentRound == totalRound;
    }
}
