package racing.domain;

import racing.util.Delimiter;

import java.util.Optional;

public class GameCondition {
    private final String[] racingCarNames;
    private final int totalRounds;

    public GameCondition(String racingCarNames, int totalRounds) {
        this.racingCarNames = Optional.of(racingCarNames.split(Delimiter.COMMA.symbol)).orElseThrow();
        this.totalRounds = Optional.of(totalRounds).orElseThrow();
    }

    public int getTotalRounds() {
        return this.totalRounds;
    }

    public String[] getTotalRacingCarCount() {
        return this.racingCarNames;
    }
}
