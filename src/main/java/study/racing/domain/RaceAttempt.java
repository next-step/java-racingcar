package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceAttempt {

    private final List<Car> cars;

    public RaceAttempt(RaceInput raceinput) {
        this.cars = initCars(raceinput);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> initCars(RaceInput raceInput) {
        List<Car> cars = new ArrayList<>();
        addCars(cars, raceInput);
        return cars;
    }

    private void addCars(List<Car> cars, RaceInput raceInput) {
        for (String name : raceInput.getNames()) {
            cars.add(new Car(name));
        }
    }
}
