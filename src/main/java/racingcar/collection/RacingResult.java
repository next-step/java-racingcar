package racingcar.collection;


import java.util.List;

public class RacingResult {
    private final List<Integer> positions;

    public RacingResult(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
