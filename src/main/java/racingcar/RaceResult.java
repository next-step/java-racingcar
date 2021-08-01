package racingcar;

public class RaceResult {
    private final Laps laps = new Laps();

    public Laps getLaps() {
        return laps;
    }

    public Lap getLastLap() {
        return laps.getLastLap();
    }

    public Records getBestRecords() {
        return getLastLap().getBestRecords();
    }

    public void recordLap(Cars cars) {
        laps.record(cars);
    }
}
