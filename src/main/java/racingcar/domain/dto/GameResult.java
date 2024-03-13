package racingcar.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<RoundResult> roundResults = new ArrayList<>();

    public void report(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public List<RoundResult> roundResults() {
        return roundResults;
    }
}
