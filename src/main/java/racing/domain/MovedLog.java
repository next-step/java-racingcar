package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class MovedLog {
    private static final int INITIAL_NUMBER = 0;

    private List<Integer> movedLogs = new ArrayList<>();

    public void addMovedLog(int distance) {
        this.movedLogs.add(getLastPosition() + distance);
    }

    public int getLastPosition() {
        int lastPosition = INITIAL_NUMBER;

        for (int i = 0; i < movedLogs.size(); i++) {
            lastPosition = Math.max(lastPosition, movedLogs.get(i));
        }

        return lastPosition;
    }

    public int getPositionByRound(int round) {
        return movedLogs.get(round);
    }
}
