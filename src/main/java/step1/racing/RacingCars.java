package step1.racing;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import step1.racing.data.RacingCar;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
        validate();
    }

    public void race(Moveable moveStrategy) {
        for (RacingCar racingCar : racingCars) {
            moveForwardIfMoveable(moveStrategy, racingCar);
        }
    }

    public List<RacingCar> getWinners() {
        int max = racingCars.stream()
                            .map(RacingCar::getPosition)
                            .max(Integer::compareTo)
                            .orElse(Integer.MAX_VALUE);

        return racingCars.stream()
                         .filter(car -> car.isGreaterThan(max))
                         .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    private void moveForwardIfMoveable(Moveable moveStrategy, RacingCar racingCar) {
        if (moveStrategy.isMoveable()) {
            racingCar.moveForward();
        }
    }

    private void validate() {
        if (racingCars.size() < 1) {
            throw new IllegalArgumentException();
        }
    }
}
