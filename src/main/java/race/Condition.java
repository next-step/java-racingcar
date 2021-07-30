package race;

public class Condition {

    private int carCount = 0;
    private int tryCount = 0;
    private String[] names;

    public static Condition of(int carCount, int tryCount, String[] names) {
        return new Condition(carCount, tryCount, names);
    }

    private Condition(int carCount, int tryCount, String[] names) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        this.names = names;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String[] getNames() {
        return names;
    }
}
