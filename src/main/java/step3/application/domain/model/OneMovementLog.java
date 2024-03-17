package step3.application.domain.model;

import java.util.List;
import java.util.Objects;

public class OneMovementLog {
    private final List<MovementLog> movementLogs;

    public OneMovementLog(List<MovementLog> movementLogs) {
        this.movementLogs = movementLogs;
    }

    public List<MovementLog> getMovementLogs() {
        return movementLogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneMovementLog)) return false;
        OneMovementLog that = (OneMovementLog) o;
        return Objects.equals(movementLogs, that.movementLogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movementLogs);
    }
}
