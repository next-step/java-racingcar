package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class MovedLog {
    private int moveCount;
    private List<Integer> movedLogs = new ArrayList<>();

    public void addMoveCount() {
        this.moveCount++;
    }

    public void addMovedLog() {
        this.movedLogs.add(this.moveCount);
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<Integer> getMovedLogs() {
        return movedLogs;
    }
}
