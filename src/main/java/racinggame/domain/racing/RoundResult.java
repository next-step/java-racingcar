package racinggame.domain.racing;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    private List<RacingCars> results;

    public RoundResult() {
        results = new ArrayList<>();
    }

    public RoundResult(List<RacingCars> racingCars) {
        List<RacingCars> cars = new ArrayList<>();
        cars.addAll(racingCars);
        this.results = cars;
    }

    public RoundResult addResult(RacingCars other) {
        List<RacingCars> cars = new ArrayList<>();
        cars.addAll(this.results);
        cars.add(other);
        return new RoundResult(cars);
    }

    public List<RacingCars> getResults() {
        return results;
    }
}
