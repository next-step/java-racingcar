package racing.model;

import java.util.List;

public class RaceResult {
    private RacingRecord racingRecord;
    private RacingWinner winner;

    public RaceResult() {
        racingRecord = new RacingRecord();
    }

    public void checkLap(List<String> skidMark) {
        racingRecord.addAll(skidMark);
    }

    public List<String> getRecord() {
        return racingRecord.getRacingRecord();
    }

    public void checkWinner(List<Car> cars) {
        this.winner = new RacingWinner(cars);
    }

    public String getWinnerName() {
        return this.winner.getWinnerName();
    }
}
