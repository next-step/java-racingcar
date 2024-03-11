package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        validateDuplicateName(racingCars);
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

    public Winners findWinners() {
        final Location maxLocation = getMaxLocation();
        final List<Name> names = racingCars.stream()
                .filter(car -> car.isSameLocation(maxLocation))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
        return new Winners(names);
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    private void validateDuplicateName(final List<RacingCar> racingCars) {
        final Set<RacingCar> nonDuplicateCars = new HashSet<>(racingCars);

        if (nonDuplicateCars.size() != racingCars.size()) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }

    private Location getMaxLocation() {
        Location maxLocation = Location.getInitLocation();
        for (final RacingCar racingCar : racingCars) {
            maxLocation = racingCar.getGreaterLocation(maxLocation);
        }
        return maxLocation;
    }
}
