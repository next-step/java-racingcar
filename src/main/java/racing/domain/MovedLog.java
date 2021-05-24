package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class MovedLog {
    private static final int INITIAL_DISTANCE = 0;

    private int finalDistance = INITIAL_DISTANCE;
    private List<Integer> movedLogs = new ArrayList<>();

    public MovedLog() {
    }

    public MovedLog(int finalDistance) {
        this.finalDistance = finalDistance;
    }

    public void addMovedLog(int distance) {
        this.movedLogs.add(finalDistance + distance);
        this.finalDistance += distance;
    }

    public boolean isWinner(int winnerPosition) {
        return this.finalDistance == winnerPosition;
    }

    public int getFinalDistance() {
        return this.finalDistance;
    }

    public int getPositionByRound(int round) {
        return this.movedLogs.get(round);
    }
}
