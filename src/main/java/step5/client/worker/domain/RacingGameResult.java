package step5.client.worker.domain;

import java.util.Collections;
import java.util.List;

public class RacingGameResult {
    private final List<RacingGameRoundResult> racingGameRoundResults;
    private final List<Car> winners;

    public RacingGameResult(final List<RacingGameRoundResult> racingGameRoundResults, final List<Car> winners) {
        this.racingGameRoundResults = Collections.unmodifiableList(racingGameRoundResults);
        this.winners = Collections.unmodifiableList(winners);
    }

    public List<RacingGameRoundResult> getRacingGameRoundResults() {
        return racingGameRoundResults;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
