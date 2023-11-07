package racing;


public class RaceInfo {

    private int cars;
    private String[] names;
    private final int trials;

    public RaceInfo(int cars, int trials) {
        this.cars = cars;
        this.trials = trials;
    }

    public RaceInfo(String[] names, int trials) {
        this.names = names;
        this.trials = trials;
    }

    public int carData() {
        return cars;
    }

    public int trialData() {
        return trials;
    }

    public String[] nameData() {
        return names;
    }
}
