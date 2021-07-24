package step3.domain;

public class GameSetting {

    private int carCount;
    private int roundCount;

    public GameSetting(int carCount, int roundCount) {
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
