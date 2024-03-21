package racingcar.vo;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private final List<RoundResult> roundResults;
    private final List<CarResult> winners;

    public GameResult(final List<RoundResult> roundResults, final List<CarResult> winners) {
        this.roundResults = roundResults;
        this.winners = winners;
    }

    public List<RoundResult> roundResults() {
        return this.roundResults;
    }

    public List<String> winnerNames() {
        return this.winners.stream()
                .map(CarResult::name)
                .collect(Collectors.toUnmodifiableList());
    }
}
