package step_3.model;

public class GameCondition {

    private final int totalRounds;
    private final int totalRacingCarCount;

    public GameCondition(int totalRounds, int totalRacingCarCount) {
        this.totalRounds = totalRounds;
        this.totalRacingCarCount = totalRacingCarCount;
    }

    public int getTotalRounds() {
        return this.totalRounds;
    }

    public int getTotalRacingCarCount() {
        return this.totalRacingCarCount;
    }
}
