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

    public Position maxPosition() {
        Position max = new Position(0);

        for (CarResult carResult : roundResult) {
            max = carResult.getPosition().biggerPosition(max);
        }
        return max;
    }
}
