package step1.racing;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import step1.racing.data.RacingCar;

public class RacingCarHandler {
    private final List<RacingCar> racingCars;

    public RacingCarHandler(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
        validate(this.racingCars);
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

    public int size() {
        return racingCars.size();
    }

    public void moveForward(int index) {
        racingCars.get(index).moveForward();
    }

    public List<RacingCar> racingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    private void validate(List<RacingCar> racingCars) {
        if (racingCars.size() < 1) {
            throw new IllegalArgumentException();
        }
    }
}
