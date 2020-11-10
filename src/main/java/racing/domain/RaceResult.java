package racing.domain;

import java.util.List;

public class RaceResult {

    private final List<Car> resultCars;

    public RaceResult(List<Car> resultCars) {
        this.resultCars = resultCars;
    }

    public List<Car> getResultCars() {
        return resultCars;
    }

}
