package racingcar.vo;

import java.util.List;

public class RoundResult {

    private final int round;
    private final List<CarResult> carResults;

    public RoundResult(final int round, final List<CarResult> carResults) {
        this.round = round;
        this.carResults = carResults;
    }

    public int round() {
        return this.round;
    }

    public List<CarResult> carResults() {
        return this.carResults;
    }
}
