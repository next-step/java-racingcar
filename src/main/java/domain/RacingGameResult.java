package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<RacingRound> racingRounds;

    public RacingGameResult(List<RacingRound> rounds) {
        if (rounds == null || rounds.size() == 0) {
            throw new IllegalArgumentException("round list is null or empty");
        }
        this.racingRounds = rounds;
    }

    public List<List<RacingCarPosition>> getRoundProgress() {
        return racingRounds.stream()
                .map(RacingRound::getCarPositions)
                .collect(Collectors.toList());
    }

    public List<String> getLastWinners() {
        RacingRound lastRound = racingRounds.get(racingRounds.size() - 1);
        return lastRound.getWinners();
    }
}
