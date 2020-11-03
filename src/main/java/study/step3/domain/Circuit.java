package study.step3.domain;

import java.util.Set;

public class Circuit {
    private final Set<Car> cars;
    private final int laps;

    public Circuit(Set<Car> cars, int laps) {
        this.cars = cars;
        this.laps = laps;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public int getLaps() {
        return laps;
    }
}
