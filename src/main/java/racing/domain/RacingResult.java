package racing.domain;

import java.util.*;

public class RacingResult {
    private final Map<Integer, List<Integer>> racingResult = new HashMap<>();

    public void put(final int racingRound, final List<Integer> carLocation) {
        racingResult.put(racingRound, carLocation);
    }

    public List<Integer> getRoundResult(final int round) {
        return racingResult.get(round);
    }

    public int getRacingRoundSize() {
        return racingResult.size();
    }
}
