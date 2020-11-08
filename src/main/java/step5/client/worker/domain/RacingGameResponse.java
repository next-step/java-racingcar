package step5.client.worker.domain;

import java.util.Collections;
import java.util.List;

public class RacingGameResponse {
    private final List<RacingGameRoundResult> racingGameRoundResults;
    private final List<String> winners;

    public RacingGameResponse(final List<RacingGameRoundResult> racingGameRoundResults, final List<String> winners) {
        this.racingGameRoundResults = Collections.unmodifiableList(racingGameRoundResults);
        this.winners = Collections.unmodifiableList(winners);
    }

    public List<RacingGameRoundResult> getRacingGameRoundResults() {
        return racingGameRoundResults;
    }

    public List<String> getWinners() {
        return winners;
    }
}
