package carracing.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(Objects.requireNonNull(racingCars));
    }

    public static RacingCars of(List<RacingCar> racingCarList) {
        return new RacingCars(racingCarList);
    }

    public List<Position> getPositions() {
        return racingCars.stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());
    }

    public void forEach(Consumer<RacingCar> action) {
        racingCars.forEach(action);
    }

    public List<RacingCar> getWinners() {
        Position farthestPosition = Collections.max(racingCars, Comparator.comparing(RacingCar::getPosition)).getPosition();
        return racingCars.stream()
                .collect(Collectors.groupingBy(RacingCar::getPosition))
                .get(farthestPosition);
    }
}
