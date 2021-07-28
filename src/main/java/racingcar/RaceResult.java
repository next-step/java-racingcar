package racingcar;

public class RaceResult {
    private Laps laps;

    public Laps getLaps() {
        return laps;
    }

    public void recordLap(Cars cars) {
        laps.record(cars);
    }
}
