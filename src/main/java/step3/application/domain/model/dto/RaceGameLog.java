package step3.application.domain.model.dto;

import java.util.List;
import java.util.Objects;

public class RaceGameLog {
    private final List<OneMovementLog> allMovementLogs;

    public RaceGameLog(List<OneMovementLog> racingHistory) {
        this.allMovementLogs = racingHistory;
    }

    public List<OneMovementLog> getAllMovementLogs() {
        return allMovementLogs;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof RaceGameLog)) return false;
        RaceGameLog that = (RaceGameLog) o;
        return Objects.equals(allMovementLogs, that.allMovementLogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allMovementLogs);
    }
}
