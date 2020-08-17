package racing.core;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<TrackInfo> nextTrial(MoveStrategy movement) {
        List<TrackInfo> tracks = new ArrayList<>();
        cars.stream().forEach(car -> tracks.add(car.move(movement)));
        return tracks;
    }
}
