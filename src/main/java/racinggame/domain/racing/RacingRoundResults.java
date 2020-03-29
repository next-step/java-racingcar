package racinggame.domain.racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingRoundResults {
    private final List<RacingCars> results;

    public RacingRoundResults() {
        results = Collections.unmodifiableList(new ArrayList<>());
    }

    public RacingRoundResults(List<RacingCars> racingCars) {
        this.results = Collections.unmodifiableList(new ArrayList<>(racingCars));
    }

    public RacingRoundResults addResult(RacingCars other) {
        List<RacingCars> cars = new ArrayList<>();
        cars.addAll(this.results);
        cars.add(other);
        return new RacingRoundResults(cars);
    }

    public List<RacingCars> getResults() {
        return results;
    }
}
