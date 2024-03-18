package racingcar.domain.dto;

import java.util.List;

public class RacingResult {
    private final List<RoundResult> roundResults;

    public RacingResult(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}
