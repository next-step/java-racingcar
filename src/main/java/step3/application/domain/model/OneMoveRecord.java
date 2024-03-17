package step3.application.domain.model;

import java.util.List;
import java.util.Objects;

public class OneMoveRecord {
    private final List<MovementLog> movementLogs;

    public OneMoveRecord(List<MovementLog> movementLogs) {
        this.movementLogs = movementLogs;
    }

    public List<MovementLog> getMovementLogs() {
        return movementLogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneMoveRecord)) return false;
        OneMoveRecord that = (OneMoveRecord) o;
        return Objects.equals(movementLogs, that.movementLogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movementLogs);
    }
}
