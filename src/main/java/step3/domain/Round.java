package step3.domain;

public class Round {

    private int roundTime;
    private int distance;

    public Round(int roundTime, int distance) {
        this.roundTime = roundTime;
        this.distance = distance;
    }

    public boolean isRound(int target) {
        return roundTime == target;
    }

    public int getDistance() {
        return distance;
    }
}
