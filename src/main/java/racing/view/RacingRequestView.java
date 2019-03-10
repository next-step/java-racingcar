package racing.view;

public class RacingRequestView {
    private int carCount;
    private int gameCount;

    public RacingRequestView(int carCount, int gameCount) {
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
