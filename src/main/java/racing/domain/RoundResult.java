package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {

    private final List<CarResult> results;

    public RoundResult(List<CarResult> results) {
        this.results = results;
    }

    public List<CarResult> getResultVOS() {
        return new ArrayList<>(results);
    }
}
