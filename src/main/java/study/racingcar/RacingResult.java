package study.racingcar;

import java.util.Collections;
import java.util.List;

public class RacingResult {

    private final List<Car> results;

    public RacingResult(List<Car> asList) {
        results = Collections.unmodifiableList(asList);
    }

    public List<Car> getResults() {
        return results;
    }
}
