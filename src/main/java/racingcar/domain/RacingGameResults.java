package racingcar.domain;

import java.util.Map;
import java.util.Set;

public class RacingGameResults {
    private static final int NUMBER_ONE = 1;

    private final Map<Integer, Cars> racingGameResults;

    public RacingGameResults(Map<Integer, Cars> racingGameResults) {
        this.racingGameResults = racingGameResults;
    }

    public Set<Map.Entry<Integer, Cars>> getGameResultSet() {
        return racingGameResults.entrySet();
    }

    public String getWinners() {
        int lastGameRound = Math.subtractExact(racingGameResults.size(), NUMBER_ONE);
        return racingGameResults.get(lastGameRound).getWinners();
    }


}
