package racingcar.domain.dto;

import racingcar.domain.Participant;
import racingcar.domain.Participants;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RacingResult {
    private final List<RoundResult> roundResults;
    private final Participants winners;

    public RacingResult(List<RoundResult> roundResults, Participants winners) {
        this.roundResults = roundResults;
        this.winners = winners;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinnerNames() {
        return StreamSupport.stream(winners.spliterator(), false)
                            .map(Participant::getName)
                            .collect(Collectors.toList());
    }
}
