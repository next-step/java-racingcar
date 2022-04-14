package step_3;

public class RacingGameConditions {

    private final int totalRounds;
    private final int totalRacingCarCount;

    public RacingGameConditions() {
        this.totalRounds = GameHost.howManyPlay();
        this.totalRacingCarCount = GameHost.howManyCars();
    }

    public int getTotalRounds() {
        return this.totalRounds;
    }

    public int getTotalRacingCarCount() {
        return this.totalRacingCarCount;
    }
}
