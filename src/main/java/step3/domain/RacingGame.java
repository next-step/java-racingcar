package step3.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> racingCars;

    private RacingGame(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingGame of(final List<String> carNames, final MovableStrategy movableStrategy) {
        final List<RacingCar> racingCars = RacingCarFactory.createCars(carNames, movableStrategy);
        return new RacingGame(racingCars);
    }

    public void moveRacingCars() {
        racingCars.stream()
                .filter(RacingCar::isMove)
                .forEach(RacingCar::moveForward);
    }

    public Snapshot createSnapshot() {
        return Snapshot.of(racingCars.stream().map(RacingCar::createRacingResult).collect(Collectors.toList()));
    }

    public List<String> selectWinnerNames() {
        final int farthestDistance = findFarthestDistance();

        return racingCars.stream()
                .filter(car -> car.isPositionEqual(farthestDistance))
                .map(RacingCar::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    private int findFarthestDistance() {
        return racingCars.stream()
                .map(RacingCar::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
