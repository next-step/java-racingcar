package racinggame.domain.result;

import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class RacingGameSnapshot {
    private final List<CarSnapshot> carSnapshots;

    public RacingGameSnapshot(List<CarSnapshot> carSnapshots) {
        this.carSnapshots = carSnapshots;
    }

    public List<CarSnapshot> getCarSnapshots() {
        return carSnapshots;
    }

    public List<String> findWinner() {
        int maxPosition = carSnapshots.stream()
                .max(comparingInt(CarSnapshot::getLocation))
                .orElseThrow(() -> new IllegalStateException("경기기록이 없어 우승자를 찾을 수 없습니다"))
                .getLocation();

        return carSnapshots.stream()
                .filter(carSnapshot -> carSnapshot.getLocation() == maxPosition)
                .map(CarSnapshot::getName)
                .collect(toList());
    }

    public int size() {
        return carSnapshots.size();
    }
}
