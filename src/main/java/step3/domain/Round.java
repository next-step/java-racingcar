package step3.domain;

import java.util.ArrayList;

public class Round {

    private ArrayList<Integer> results = new ArrayList<>();

    public void start(RacingCars cars) {
        for (Car car : cars.getCars()) {
            car.run();
            results.add(car.getRunDistance());
        }
    }

    public ArrayList<Integer> getResults() {
        return results;
    }
}
