package racingCar;

public class GameRequest {
    private int carCount;
    private int tryCount;

    public GameRequest(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int carCount() {
        return carCount;
    }

    public int tryCount() {
        return tryCount;
    }
}
