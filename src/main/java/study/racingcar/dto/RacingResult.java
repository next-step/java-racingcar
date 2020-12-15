package study.racingcar.dto;

import java.util.Collections;
import java.util.List;
import study.racingcar.domain.Car;

public class RacingResult {

    private final List<Car> results;

    public RacingResult(List<Car> asList) {
        results = Collections.unmodifiableList(asList);
    }

    public List<Car> getResults() {
        return results;
    }
}
