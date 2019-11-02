package step1.racing;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import step1.racing.data.RacingCar;

public class RacingCarHandler {
    private final List<RacingCar> racingCars;
    private final int playTimes;

    public RacingCarHandler(List<RacingCar> racingCars, int playTimes) {
        this.racingCars = racingCars;
        this.playTimes = playTimes;
        validate();
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

    public void race(Moveable moveStrategy) {
        racingCars.forEach(racingCar -> {
            if (moveStrategy.isMoveable()) {
                racingCar.moveForward();
            }
        });
    }

    public List<RacingCar> racingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    private void validate() {
        if (racingCars.size() < 1 || playTimes < 1) {
            throw new IllegalArgumentException();
        }
    }
}
