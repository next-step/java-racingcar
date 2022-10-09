package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.Racers;

public class RacingResult {

    private final List<RacerResult> racerResults = new ArrayList<>();

    private RacingResult() {
    }

    public static RacingResult from(final Racers racers) {
        RacingResult racingResult = new RacingResult();
        racers.getCars().stream()
            .map(RacerResult::from)
            .forEach(racingResult.racerResults::add);

        return racingResult;
    }

    public List<RacerResult> getRacerResults() {
        return racerResults;
    }
}
