package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MoveResult {

    private final List<Boolean> moveLog;

    public MoveResult() {
        this.moveLog = new ArrayList<>();
    }

    public MoveResult(List<Boolean> moveLog) {
        this.moveLog = moveLog;
    }

    public List<Boolean> getMoveLog() {
        return moveLog;
    }

    public void addMoveLog(boolean movedFlag) {
        moveLog.add(movedFlag);
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
        return Objects.equals(moveLog, that.moveLog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveLog);
    }

}
