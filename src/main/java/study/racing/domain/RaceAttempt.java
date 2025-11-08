package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceAttempt {

    private final List<String> results;

    public RaceAttempt(int numberOfCars) {
        this.results = initRaceAttempt(numberOfCars);
    }

    public List<String> getResults() {
        return this.results;
    }

    public List<String> initRaceAttempt(int numberOfCars) {
        List<String> cars = new ArrayList<>();
        addCar(numberOfCars, cars);
        return cars;
    }

    private void addCar(int numberOfCars, List<String> cars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add("");
        }
    }
}
