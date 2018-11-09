package racingGame.service;

import racingGame.domain.RacingCarDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    private List<RacingCarDTO> snapshots;

    public RacingCarService(List<RacingCarDTO> snapshots) {
        this.snapshots = snapshots;
    }

    public int getHighestPosition() {
        return Collections.max(extractCarPositions());
    }

    public List<Integer> extractCarPositions() {
        return this.snapshots.stream().map(snapshot -> snapshot.getPosition()).collect(Collectors.toList());
    }

    public List<String> extractCarNamesByPosition(int position) {
        return this.snapshots.stream()
                .filter(snapshot -> snapshot.isMatchPosition(position))
                .map(snapshot -> snapshot.getName())
                .collect(Collectors.toList());
    }
}
