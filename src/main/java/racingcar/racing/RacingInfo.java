package racingcar.racing;

public class RacingInfo {
    private final int carCount;
    private final int lapCount;

    public RacingInfo(int carCount, int lapCount) {
        this.carCount = carCount;
        this.lapCount = lapCount;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getLapCount() {
        return this.lapCount;
    }
}
