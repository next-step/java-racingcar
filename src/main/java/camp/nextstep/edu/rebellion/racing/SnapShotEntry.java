package camp.nextstep.edu.rebellion.racing;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SnapShotEntry {
    private final List<RacingCar> cars;

    public SnapShotEntry(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() >= getMostDistancePosition())
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getMostDistancePosition() {
        return cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .getAsInt();
    }
}
