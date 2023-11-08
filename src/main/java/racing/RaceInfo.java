package racing;


public class RaceInfo {

    private String[] names;
    private final int trials;

    public RaceInfo(String[] names, int trials) {
        this.names = names;
        this.trials = trials;
    }

    public int trialData() {
        return trials;
    }

    public String[] nameData() {
        return names;
    }
}
