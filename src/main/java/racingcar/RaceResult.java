package racingcar;

public class RaceResult {
    private final Laps laps = new Laps();

    public Laps getLaps() {
        return laps;
    }

    public void recordLap(Cars cars) {
        laps.record(cars);
    }
}
