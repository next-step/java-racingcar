package racinggame.domain.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameResult {
    private final int totalRound;
    private final Map<Integer, RacingGameSnapshot> results = new HashMap<>();

    public RacingGameResult(int totalRound) {
        this.totalRound = totalRound;
    }

    public void record(int round, RacingGameSnapshot gameSnapshot) {
        results.put(round, gameSnapshot);
    }

    public List<String> findFinalWinners() {
        return results.get(totalRound)
                .findWinner();
    }

    public List<RacingGameSnapshot> findAllSnapshots() {
        List<RacingGameSnapshot> racingGameResults = new ArrayList<>();

        for (int i = 1; i <= totalRound; i++) {
            racingGameResults.add(results.get(i));
        }

        return racingGameResults;
    }
}
