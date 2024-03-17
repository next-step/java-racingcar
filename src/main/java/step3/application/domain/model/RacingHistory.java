package step3.application.domain.model;

import java.util.List;
import java.util.Objects;

public class RacingHistory {
    private final List<OneMovementLog> racingRecords;

    public RacingHistory(List<OneMovementLog> racingHistory) {
        this.racingRecords = racingHistory;
    }

    public List<OneMovementLog> getRacingRecords() {
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
