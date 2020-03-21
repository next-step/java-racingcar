package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<RacingRound> racingRounds;

    public RacingGameResult(List<RacingRound> rounds) {
        if(rounds == null) {
            throw new IllegalArgumentException("round list is null");
        }
        this.racingRounds = rounds;
    }

    public List<List<Integer>> getResult() {
        return racingRounds.stream()
                .map(round -> round.getCarPositions())
                .collect(Collectors.toList());
    }
}
