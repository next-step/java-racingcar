package study.racing.domain;

public class RoundStatus {
    private final int maxRounds;
    private int currentRound;

    public RoundStatus(int maxRounds) {
        this.maxRounds = maxRounds;
        this.currentRound = 0;
    }

    public boolean hasNextRound() {
        return currentRound < maxRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }
    public void next(){
        if(!hasNextRound()){
            throw new IllegalStateException("다음 라운드가 없습니다.");
        }
        currentRound++;
    }
}
