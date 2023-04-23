package race;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public List<CarResult> startLap() {
        cars.moveAll();
        return cars.getCarList()
                .stream()
                .map(CarResult::from)
                .collect(Collectors.toList());
    }

    public List<CarResult> getWinners() {
        Position topScore = cars.getFarthestPosition();

        return cars.getCarList()
                .stream()
                .filter(it -> it.getPosition().equals(topScore))
                .map(CarResult::from)
                .collect(Collectors.toList());
    }
}
