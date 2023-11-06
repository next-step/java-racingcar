package study;

public class RaceEntry {
    private final int carCount;
    private final int tryCount;

    private RaceEntry(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public static RaceEntry of(int carCount, int tryCount) {
        return new RaceEntry(carCount, tryCount);
    }

    public int carCount() {
        return carCount;
    }

    public int tryCount() {
        return tryCount;
    }
}
