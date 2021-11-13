package racing.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 *
 * RacingResult
 *
 * @version 1.0.0
 *
 * 2021-11-11
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

    public List<RoundResult> getResult() {
        return Collections.unmodifiableList(roundResults);
    }
}
