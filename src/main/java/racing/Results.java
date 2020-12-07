package racing;

import racing.domain.Car;
import racing.domain.Result;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public List<Car> getFinalWinners() {
        Result finalResult = results.get(results.size() - 1);
        return finalResult.getWinners();
    }

    public List<Result> getResults() {
        return results;
    }
}
