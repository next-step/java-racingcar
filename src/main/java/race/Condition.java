package race;

import java.util.List;

public class Condition {

    private int carCount;
    private int tryCount;
    private List<String> names;

    public Condition(int carCount, int tryCount, List<String> names) {
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

    public List<String> getNames() {
        return names;
    }
}
