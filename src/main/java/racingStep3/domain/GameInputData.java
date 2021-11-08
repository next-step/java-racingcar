package racingStep3.domain;

public class GameInputData {

    private final int carCount;
    private final int tryCount;

    private GameInputData(int carCount, int tryCount) {

        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public static GameInputData of(int carCount, int tryCount) {
        return new GameInputData(carCount, tryCount);
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
