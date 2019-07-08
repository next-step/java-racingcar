package racing.domain;

import java.util.List;

public class TrackResult {
    private List<Car> cars;

    public TrackResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
