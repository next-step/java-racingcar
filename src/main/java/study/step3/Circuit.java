package study.step3;

import java.util.Set;

class Circuit {
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
