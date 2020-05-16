package racing.dto;

import racing.utils.EmptyCheckUtil;

import java.util.Collections;
import java.util.List;

public class RacingGameResult {
    private final List<CarRaceResult> carRaceResults;
    private final int round;

    public RacingGameResult(List<CarRaceResult> carRaceResults, int round) {
        EmptyCheckUtil.emptyCheck(carRaceResults);
        this.validateRound(round);
        this.carRaceResults = Collections.unmodifiableList(carRaceResults);
        this.round = round;
    }

    private void validateRound(int round) {
        if (round < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getRound() {
        return this.round;
    }

    public List<CarRaceResult> getCarRaceResults() {
        return this.carRaceResults;
    }
}
