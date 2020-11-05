package step3.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingMap {
    private final List<RacingCarLocation> racingCarLocations;

    private RacingMap(final List<RacingCarLocation> racingCarLocations) {
        this.racingCarLocations = racingCarLocations;
    }

    public static RacingMap of(final List<RacingCar> racingCars) {
        final List<RacingCarLocation> racingCarLocations = racingCars.stream()
                .map(racingCar -> new RacingCarLocation(racingCar, racingCar.getStartPosition()))
                .collect(Collectors.toList());
        return new RacingMap(racingCarLocations);
    }

    public void moveRacingCars(final int unitOfForward) {
        racingCarLocations
                .stream()
                .map(RacingCarLocation::getCar)
                .filter(RacingCar::isMovable)
                .forEach(racingCar -> move(racingCar, unitOfForward));
    }

    public List<RacingCar> getRacingCars() {
        final List<RacingCar> racingCars = racingCarLocations.stream().map(RacingCarLocation::getCar).collect(Collectors.toList());
        return Collections.unmodifiableList(racingCars);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private void move(final RacingCar racingCar, final int unitOfForward) {
        racingCarLocations.stream().filter(racingCarLocation -> racingCarLocation.getCar() == racingCar)
                .findAny()
                .get()
                .move(unitOfForward);
    }

    public RacingMap clone() {
        final List<RacingCarLocation> clonedRacingCarLocations = racingCarLocations.stream()
                .map(RacingCarLocation::clone)
                .collect(Collectors.toList());
        return new RacingMap(Collections.unmodifiableList(clonedRacingCarLocations));
    }

    public Snapshot createSnapshot() {
        return Snapshot.of(clone());
    }

    public int findPosition(final RacingCar racingCar) {
        return racingCarLocations.stream()
                .filter(racingCarLocation -> racingCarLocation.getCar().equals(racingCar))
                .findAny()
                .map(RacingCarLocation::getLocation)
                .orElse(0);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public List<String> selectWinnerNames() {
        final int farthestLocation = racingCarLocations.stream()
                .map(RacingCarLocation::getLocation)
                .max(Integer::compareTo)
                .get();

        return racingCarLocations.stream()
                .filter(racingCarLocation -> racingCarLocation.getLocation().equals(farthestLocation))
                .map(RacingCarLocation::getCar)
                .map(RacingCar::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }
}
