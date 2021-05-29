package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class DistanceLog {
    private int distance;
    private List<Integer> distanceLogs = new ArrayList<>();

    public DistanceLog() {
    }

    public DistanceLog(int initDistance) {
        this.distance = initDistance;
    }

    public void addDistanceLog(int distance) {
        this.distanceLogs.add(this.distance + distance);
        this.distance += distance;
    }

    public boolean isSamePosition(int winnerPosition) {
        return this.distance == winnerPosition;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getDistanceByRound(int round) {
        return this.distanceLogs.get(round);
    }
}
