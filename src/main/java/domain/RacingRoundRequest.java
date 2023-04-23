package domain;

public class RacingRoundRequest {
    private int numberOfRounds;

    public RacingRoundRequest(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}
