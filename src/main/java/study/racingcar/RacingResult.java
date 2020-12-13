package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<Car> results = new ArrayList<>();

    public RacingResult(List<Car> asList) {
        results.addAll(asList);
    }

    public void addResult(Car position) {
        results.add(position);
    }

    public List<Car> getResults() {
        return results;
    }
}
