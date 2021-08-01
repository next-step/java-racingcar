package racingcar;

public class RaceResult {
    private final Laps laps = new Laps();

    public Laps getLaps() {
        return laps;
    }

    public Lap getLastLap() {
        return laps.getLastLap();
    }

    public Winners getWinners() {
        Winners winners = new Winners();

        for (Record record : getLastLap().getRecords()) {
            winners.updateWinner(record);
        }

        return winners;
    }

    public void recordLap(Cars cars) {
        laps.record(cars);
    }
}
