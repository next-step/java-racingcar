package camp.nextstep.edu.rebellion.racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SnapShotEntry {
    private final List<RacingCar> cars;

    public SnapShotEntry(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(copy(cars));
    }

    public List<String> getWinners() {
        int mostDistancePosition = getMostDistancePosition();
        return cars.stream()
                .filter(car -> car.getPosition() >= mostDistancePosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getMostDistancePosition() {
        return cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .getAsInt();
    }

    private List<RacingCar> copy(List<RacingCar> cars) {
        return cars
                .stream()
                .map(RacingCar::copy)
                .collect(Collectors.toList());
    }
}
