package racingcar.domain;

import java.util.List;

public class RacingResult {
    private final int attempt;
    private List<Integer> positions;

    public RacingResult(int attempt, List<Integer> positions) {
        this.attempt = attempt;
        this.positions = positions;
    }

    public List<Integer> getPositions(){
        return positions;
    }

}
