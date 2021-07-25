package race;

public class Condition {

    private int carCount = 0;
    private int tryCount = 0;

    public static Condition of(int carCount, int tryCount) {
        return new Condition(carCount, tryCount);
    }

    private Condition(int carCount, int tryCount) {
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
