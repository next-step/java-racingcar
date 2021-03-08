package step3.ui.dto;

public class RequestRacingGame {

    private final int carCount;
    private final int tryCount;

    public RequestRacingGame(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getCarCount() {
        return carCount;
    }
}
