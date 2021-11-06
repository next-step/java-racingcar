package racingcar.gameinfo;

public class CountInfo {

    private final int carCount;
    private final int tryCount;

    public CountInfo(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
