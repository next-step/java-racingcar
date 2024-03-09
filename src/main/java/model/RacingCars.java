package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    private RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(final int racingCarNumber) {
        final List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < racingCarNumber; i++) {
            racingCars.add(new RacingCar());
        }
        return new RacingCars(racingCars);
    }

    public void move(final RandomNumberGenerator randomNumberGenerator) {
        racingCars.forEach(car -> car.move(randomNumberGenerator.generate()));
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
