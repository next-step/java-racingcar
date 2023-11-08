package racingcar.domain;

public class RaceCommand {
    private int carCount;
    private int tryCount;

    public RaceCommand(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
