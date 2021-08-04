package racingcar.domain;

public class RaceResult {
    private final Laps laps = new Laps();

    public Laps getLaps() {
        return laps;
    }

    public Lap getLastLap() {
        return laps.getLastLap();
    }

    public Winners getWinners() {
        return new Winners(getLastLap().getRecords());
    }

    public void recordLap(Cars cars) {
        laps.record(cars);
    }
}
