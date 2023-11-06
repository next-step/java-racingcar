package racing.domain;

public class RacingGame {
    private int carCount;
    private int gameCount;

    public RacingGame(int carCount, int gameCount) {
        this.carCount = carCount;
        this.gameCount = gameCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }


}
