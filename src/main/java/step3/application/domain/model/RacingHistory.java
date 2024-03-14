package step3.application.domain.model;

import java.util.List;

public class RacingHistory {
    private final List<OneMoveRecord> racingRecords;

    public RacingHistory(List<OneMoveRecord> racingHistory) {
        this.racingRecords = racingHistory;
    }

    public List<OneMoveRecord> getRacingRecords() {
        return racingRecords;
    }
}
