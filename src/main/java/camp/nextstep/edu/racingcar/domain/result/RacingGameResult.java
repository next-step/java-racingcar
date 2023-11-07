package camp.nextstep.edu.racingcar.domain.result;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {

    private List<RoundResult> roundResults;

    public RacingGameResult() {
        this.roundResults = new ArrayList<>();
    }

    public void report(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (RoundResult roundResult : roundResults) {
            result.append(roundResult.toString()).append('\n');
        }
        return result.toString();
    }
}
