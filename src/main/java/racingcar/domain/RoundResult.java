package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    private final List<CarSnapshot> snapshots;

    public RoundResult(List<CarSnapshot> snapshots) {
        validate(snapshots);
        this.snapshots = List.copyOf(snapshots);
    }

    private void validate(List<CarSnapshot> positions) {
        if (positions == null || positions.isEmpty()) {
            throw new IllegalArgumentException("스냅샷 목록은 비어있을 수 없습니다.");
        }
    }

    public List<CarSnapshot> snapshots() {
        return this.snapshots;
    }

    public List<String> findLeaders() {
        List<String> leaders = new ArrayList<>();

        for (CarSnapshot snapshot : snapshots) {
            if (snapshot.distance() == maxDistance()) {
                leaders.add(snapshot.name());
            }
        }

        return leaders;
    }

    private int maxDistance() {
        int maxDistance = 0;

        for (CarSnapshot snapshot : snapshots) {
            int distance = snapshot.distance();

            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        return maxDistance;
    }
}
