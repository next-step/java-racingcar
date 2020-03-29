package racinggame.domain.racing;

import java.util.ArrayList;
import java.util.List;

public class RacingRoundResult {
    private List<RacingCars> results;

    public RacingRoundResult() {
        results = new ArrayList<>();
    }

    public RacingRoundResult(List<RacingCars> racingCars) {
        List<RacingCars> cars = new ArrayList<>();
        cars.addAll(racingCars);
        this.results = cars;
    }

    public RacingRoundResult addResult(RacingCars other) {
        List<RacingCars> cars = new ArrayList<>();
        cars.addAll(this.results);
        cars.add(other);
        return new RacingRoundResult(cars);
    }

    public List<RacingCars> getResults() {
        return results;
    }
}
