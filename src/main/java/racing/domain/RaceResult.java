package racing.domain;

import java.util.List;

public class RaceResult {
    private RacingRecord racingRecord;
    private RacingWinners winners;

    public RaceResult(RacingRecord racingRecord, RacingWinners winners) {
        this.racingRecord = racingRecord;
        this.winners = winners;
    }

    public List<String> getRecord() {
        return racingRecord.getRacingRecord();
    }

    public List<String> getWinnersName() {
        return this.winners.getWinnersName();
    }
}
