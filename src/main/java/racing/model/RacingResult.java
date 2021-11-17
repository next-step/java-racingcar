package racing.model;

import java.util.*;

/*
 *
 * RacingResult
 *
 * @version 1.0.0
 *
 * 2021-11-12
 *
 * Copyright tnals1422
 */
public class RacingResult {

    private final List<RoundResult> roundResults;

    public RacingResult() {
        roundResults = new LinkedList<>();
    }

    public void add(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public List<RoundResult> getRecords() {
        return Collections.unmodifiableList(roundResults);
    }

    public String getWinner() {
        return new Cars(roundResults.get((roundResults.size() - 1)).getRecords()).getWinner();
    }
}
