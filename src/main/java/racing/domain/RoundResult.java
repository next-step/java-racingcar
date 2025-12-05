package racing.domain;

import java.util.Collections;
import java.util.List;

public class RoundResult {

    private final List<Integer> roundResult;

    public RoundResult(List<Integer> roundResult) {
        this.roundResult = roundResult;
    }

    public List<Integer> getRoundResult() {
        return Collections.unmodifiableList(roundResult);
    }
}
