package racing.domain;

import java.util.Collections;
import java.util.List;

public class RoundResult {

    private final List<CarResult> roundResult;

    public RoundResult(List<CarResult> roundResult) {
        this.roundResult = roundResult;
    }

    public List<CarResult> getRoundResult() {
        return Collections.unmodifiableList(roundResult);
    }
}
