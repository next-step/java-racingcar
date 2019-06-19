package racingcar.domain;

import java.util.Map;
import java.util.Set;

import static racingcar.domain.RacingGameConstant.NUMBER_ONE;

public class RacingGameResults {
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
