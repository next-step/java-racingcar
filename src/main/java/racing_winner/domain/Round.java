package racing_winner.domain;

public final class Round {
    private static final int INIT_ROUND = 1;
    private int trial;

    public Round(final int trial) {
        if(trial < 1){
            throw new IllegalArgumentException("경기 횟수는 1회 이상이어야합니다.");
        }
        this.trial = trial;
    }

    public void next(){
        trial--;
    }

    public boolean isFinish() {
        return trial < INIT_ROUND;
    }
}
