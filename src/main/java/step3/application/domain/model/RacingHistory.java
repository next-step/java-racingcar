package step3.application.domain.model;

import java.util.List;
import java.util.Objects;

public class RacingHistory {
    private final List<OneMoveRecord> racingRecords;

    public RacingHistory(List<OneMoveRecord> racingHistory) {
        this.racingRecords = racingHistory;
    }

    public List<OneMoveRecord> getRacingRecords() {
        return racingRecords;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof RacingHistory)) return false;
        RacingHistory that = (RacingHistory) o;
        return Objects.equals(racingRecords, that.racingRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingRecords);
    }
}
