package step5.racing.domain;

import java.util.Collections;
import java.util.List;

public class RoundResult {

    private final List<CarResult> carResults;

    public RoundResult(List<CarResult> carResults) {
        this.carResults = carResults;
    }

    public List<CarResult> getRoundResult() {
        return Collections.unmodifiableList(carResults);
    }
}
