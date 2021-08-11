package racing_winner.domain;

public class Round {
    private static final int INIT_ROUND = 1;
    private int trial;

    public Round(int trial) {
        if(trial < 1){
            throw new IllegalArgumentException("경기 횟수는 1회 이상이어야합니다.");
        }
        this.trial = trial;
    }

    public void race(){
        trial--;
    }

    public boolean isFinish() {
        return trial < INIT_ROUND;
    }
}
