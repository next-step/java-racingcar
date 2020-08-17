package racing.core.domain;

import racing.core.patterns.MoveStrategy;
import racing.core.dto.TrackInfo;
import racing.core.dto.Trial;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Trial nextTrial(MoveStrategy movement) {
        List<TrackInfo> tracks = new ArrayList<>();
        cars.stream().forEach(car -> tracks.add(car.move(movement)));
        return new Trial(tracks);
    }
}
