package domain.dto;

import java.util.List;

public class RacingResults {
    private final List<RacingResult> racingResults;

    private RacingResults(List<RacingResult> racingResults) {
        this.racingResults = racingResults;
    }

    public static RacingResults from(List<RacingResult> racingResults) {
        return new RacingResults(racingResults);
    }

    public List<RacingResult> getRacingResults() {
        return racingResults;
    }
}
