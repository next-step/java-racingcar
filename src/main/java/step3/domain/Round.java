package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private List<Integer> results = new ArrayList<>();

    public void start(RacingCars cars) {
        for (Car car : cars.getCars()) {
            car.run();
            results.add(car.getRunDistance());
        }
    }

    public List<Integer> getResults() {
        return results;
    }
}
