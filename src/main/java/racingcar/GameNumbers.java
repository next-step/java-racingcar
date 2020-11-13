package racingcar;

public class GameNumbers {
    private int tryCounts;
    private int round;

    public GameNumbers(int tryCounts, int round){
        this.tryCounts = tryCounts;
        this.round = round;
    }

    public GameNumbers(int tryCounts) {
        this.tryCounts = tryCounts;
    }

    public void increaseRound() {
        round++;
    }

    public int getTryCounts() {
        return tryCounts;
    }

    public int getRound() {
        return round;
    }

}
