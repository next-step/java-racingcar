package domain;

public class RacingCar {

    private static final int BENCHMARK = 4;

    private final String name;
    private int laps = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int record() {
        return laps;
    }

    public void race(int bound) {
        if (bound >= BENCHMARK) {
            laps++;
        }
    }
}
