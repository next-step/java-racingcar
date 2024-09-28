package race;

public class RaceInput {

    private int carCount;
    private int tryCount;

    public RaceInput (int carCount, int tryCount) {
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
