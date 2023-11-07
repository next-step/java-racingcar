package racing;


public class RaceInfo {

    private final int cars;
    private final int trials;

    public RaceInfo(int cars, int trials) {
        this.cars = cars;
        this.trials = trials;
    }

    public int carData() {
        return cars;
    }

    public int trialData() {
        return trials;
    }
}
