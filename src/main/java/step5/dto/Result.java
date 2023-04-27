package step5.dto;

import step5.domain.RacingGameResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private final List<RoundResult> roundResults;
    private final List<String> winners;

    private Result(List<RoundResult> roundResults, List<String> winners) {
        this.roundResults = roundResults;
        this.winners = winners;
    }

    public static Result from(List<RacingGameResult> racingGameResults) {
        List<RoundResult> roundResults = racingGameResults.stream()
                .map(RoundResult::from)
                .collect(Collectors.toList());
        List<String> winners = racingGameResults.get(racingGameResults.size() - 1)
                .getWinners();

        return new Result(roundResults, winners);
    }

    public List<RoundResult> getResults() {
        return Collections.unmodifiableList(roundResults);
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
