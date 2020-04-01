package racinggame.domain.racing;

import racinggame.domain.car.Cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingRoundResults {

    private final List<Cars> results;

    public RacingRoundResults() {
        this(new ArrayList<>());
    }

    public RacingRoundResults(List<Cars> cars) {
        this.results = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public RacingRoundResults(RacingRoundResults results) {
        this(new ArrayList<>(results.results));
    }

    public RacingRoundResults addResult(Cars other) {
        List<Cars> cars = new ArrayList<>();
        cars.addAll(this.results);
        cars.add(other);
        return new RacingRoundResults(cars);
    }

    public List<Cars> getResults() {
        return new ArrayList<>(this.results);
    }
}
