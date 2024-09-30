package racing.domain;

public class RacingGame {

    private final int roundCount;

    private final int carCount;

    private RacingGame(int roundCount, int carCount) {
        this.roundCount = roundCount;
        this.carCount = carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public static RacingGame setUp(int roundCount, int carCount) {
        return new RacingGame(roundCount, carCount);
    }
}
