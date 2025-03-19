package racing.config;

public class GameConfig {
    String[] carNames;
    int attemptCount;

    public GameConfig(String[] carNames, int attemptCount) {
        this.carNames = carNames;
        this.attemptCount = attemptCount;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}