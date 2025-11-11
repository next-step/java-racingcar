package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    private final List<CarSnapshot> snapshots;

    public RoundResult(List<CarSnapshot> snapshots) {
        validate(snapshots);
        this.snapshots = List.copyOf(snapshots);
    }

    private void validate(List<CarSnapshot> snapshots) {
        if (snapshots == null || snapshots.isEmpty()) {
            throw new IllegalArgumentException("스냅샷 목록은 비어있을 수 없습니다.");
        }
    }

    public List<CarSnapshot> snapshots() {
        return this.snapshots;
    }

    public List<String> findLeaders() {
        List<String> leaders = new ArrayList<>();

        for (CarSnapshot snapshot : this.snapshots) {
            addIfLeader(snapshot, leaders);
        }

        return leaders;
    }

    private void addIfLeader(CarSnapshot snapshot, List<String> leaders) {
        if (snapshot.distance() == maxDistance()) {
            leaders.add(snapshot.name());
        }
    }

    private int maxDistance() {
        int max = 0;

        for (CarSnapshot snapshot : snapshots) {
            max = largerDistance(max, snapshot.distance());
        }

        return max;
    }

    private int largerDistance(int currentMax, int candidate) {
        return Math.max(candidate, currentMax);
    }
}
