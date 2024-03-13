package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MoveResult {

    private final List<Boolean> moveLogs;

    public MoveResult() {
        this.moveLogs = new ArrayList<>();
    }

    public MoveResult(List<Boolean> moveLogs) {
        this.moveLogs = moveLogs;
    }

    public List<Boolean> getMoveLogs() {
        return moveLogs;
    }

    public void addMoveLog(boolean movedFlag) {
        moveLogs.add(movedFlag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoveResult that = (MoveResult) o;
        return Objects.equals(moveLogs, that.moveLogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveLogs);
    }

}
