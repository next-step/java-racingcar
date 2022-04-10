package racingcar.dto;

import java.util.List;

public class RoundResults {
    private final List<RoundResult> roundResults;

    public RoundResults(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}
