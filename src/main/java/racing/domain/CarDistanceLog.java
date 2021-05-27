package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarDistanceLog {
    private static final int INITIAL_DISTANCE = 0;

    private int finalDistance = INITIAL_DISTANCE;
    private List<Integer> distanceLogs = new ArrayList<>();

    public CarDistanceLog() {
    }

    public CarDistanceLog(int finalDistance) {
        this.finalDistance = finalDistance;
    }

    public void addMovedLog(int distance) {
        this.distanceLogs.add(finalDistance + distance);
        this.finalDistance += distance;
    }

    public boolean isSamePosition(int winnerPosition) {
        return this.finalDistance == winnerPosition;
    }

    public int getFinalDistance() {
        return this.finalDistance;
    }

    public int getDistanceByRound(int round) {
        return this.distanceLogs.get(round);
    }
}
