package racing.core.domain;

import racing.core.dto.TrackInfo;
import racing.core.dto.Trial;
import racing.core.patterns.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int WINNER = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참가할 자동차가 존재하지 않습니다.");
        }
        this.cars = cars;
    }

    public Trial nextTrial(MoveStrategy movement) {
        List<TrackInfo> tracks = new ArrayList<>();
        cars.stream().forEach(car -> tracks.add(car.move(movement)));
        return new Trial(tracks);
    }

    public List<String> getNamesOfWinners() {
        List<Car> orderedCars = getCarsOrderedByPositionDesc();
        return orderedCars.stream()
                .filter(car -> orderedCars.get(WINNER).isSamePosition(car))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> getCarsOrderedByPositionDesc() {
        List<Car> copy = new ArrayList<>(cars);
        Collections.sort(copy);
        return copy;
    }
}
