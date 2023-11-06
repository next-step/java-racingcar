package racing;

public class RacingGame {
    private int gameCount;
    private int carCount;

    public RacingGame(int gameCount, int carCount) {
        this.gameCount = gameCount;
        this.carCount = carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public int getCarCount() {
        return carCount;
    }
}
