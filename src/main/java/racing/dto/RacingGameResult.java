package racing.dto;

import racing.utils.EmptyCheckUtil;

import java.util.Collections;
import java.util.List;

public class RacingGameResult {
    private final List<CarRaceResult> carRaceResults;
    private final int round;
    private final int maxPosition;

    public RacingGameResult(List<CarRaceResult> carRaceResults, int round) {
        EmptyCheckUtil.emptyCheck(carRaceResults);
        this.validateRound(round);
        this.carRaceResults = Collections.unmodifiableList(carRaceResults);
        this.round = round;
        this.maxPosition = this.calculateMaxPosition();
    }

    private void validateRound(int round) {
        if (round < 1) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateMaxPosition() {
        return this.carRaceResults.stream()
                .map(carRaceResult -> carRaceResult.getPosition())
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int getRound() {
        return this.round;
    }

    public List<CarRaceResult> getCarRaceResults() {
        return this.carRaceResults;
    }

    public int getMaxPosition() {
        return this.maxPosition;
    }
}
