package race.domain;

import java.util.List;

public class Condition {

    private final int carCount;
    private final int tryCount;
    private final List<String> names;

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
