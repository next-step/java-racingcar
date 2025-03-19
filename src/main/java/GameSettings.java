public class GameSettings {
    private final int carCount;
    private final int roundCount;

    public GameSettings(int carCount, int roundCount) {
        this.carCount = carCount;
        this.roundCount = roundCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }
} 