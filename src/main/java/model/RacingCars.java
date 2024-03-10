package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(final List<String> racingCarNames) {
        final List<RacingCar> racingCars = new ArrayList<>();
        for (final String racingCarName : racingCarNames) {
            racingCars.add(new RacingCar(new Name(racingCarName)));
        }
        return new RacingCars(racingCars);
    }

    public void move(final RandomNumberGenerator randomNumberGenerator) {
        racingCars.forEach(car -> car.move(randomNumberGenerator.generate()));
    }

    public List<Name> findWinners() {
        return racingCars.stream()
                .filter(car -> car.getLocation().getValue() == getMaxLocation())
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    private int getMaxLocation() {
        return racingCars.stream()
                .mapToInt(car -> car.getLocation().getValue())
                .max()
                .orElse(0);
    }
}
