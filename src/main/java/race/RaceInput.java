package race;

public class RaceInput {
    private final int carCount;
    private final int randomStopOrGoCount;

    public RaceInput(int carCount, int randomStopOrGoCount) {
        this.carCount = carCount;
        this.randomStopOrGoCount = randomStopOrGoCount;
    }

    public int carCount() {
        return this.carCount;
    }

    public int randomStopOrGoCount() {
        return this.randomStopOrGoCount;
    }
}
