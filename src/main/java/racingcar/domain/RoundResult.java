package racingcar.domain;

import java.util.List;

public class RoundResult {
    private final List<Integer> positions;

    public RoundResult(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
