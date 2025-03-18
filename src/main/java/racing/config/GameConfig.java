package racing.config;

public class GameConfig {
    int carCount;
    int attemptCount;

    public GameConfig(int carCount, int attemptCount) {
        this.carCount = carCount;
        this.attemptCount = attemptCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}