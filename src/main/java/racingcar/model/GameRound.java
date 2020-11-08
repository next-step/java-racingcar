package racingcar.model;

public class GameRound {

    private int totalRound;
    private int currentRound;
    private boolean isAllRoundFinish;

    public GameRound(int totalRound) {
        this.totalRound = totalRound;
    }

    public void roundFinish() {
        this.currentRound++;
        if(currentRound == totalRound){
            isAllRoundFinish = true;
        }
    }

    public boolean isAllRoundFinish() {
        return isAllRoundFinish;
    }
}
