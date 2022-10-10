package racingcar.output;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Racers;

public class RacingResult {

    private List<RacerResult> racerResults;

    private RacingResult() {
    }

    public RacingResult(final List<RacerResult> racerResults) {
        this.racerResults = racerResults;
    }

    public static RacingResult from(final Racers racers) {
        List<RacerResult> racerResults = racers.getCars().stream()
            .map(RacerResult::from)
            .collect(Collectors.toList());

        return new RacingResult(racerResults);
    }

    public List<RacerResult> getRacerResults() {
        return racerResults;
    }
}
