package step3.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private static final SelectWinnerStrategy DEFAULT_SELECT_WINNER_STRATEGY = new SelectFarthestDistanceWinnerStrategy();
    private final List<RacingCar> racingCars;
    private final SelectWinnerStrategy selectWinnerStrategy;

    private RacingGame(final List<RacingCar> racingCars, final SelectWinnerStrategy selectWinnerStrategy) {
        this.racingCars = Collections.unmodifiableList(racingCars);
        this.selectWinnerStrategy = selectWinnerStrategy;
    }

    public static RacingGame of(final List<String> carNames, final MovableStrategy movableStrategy) {
        final List<RacingCar> racingCars = RacingCarFactory.createCars(carNames, movableStrategy);
        return new RacingGame(racingCars, DEFAULT_SELECT_WINNER_STRATEGY);
    }

    public static RacingGame of(final List<String> carNames, final MovableStrategy movableStrategy, final SelectWinnerStrategy selectWinnerStrategy) {
        final List<RacingCar> racingCars = RacingCarFactory.createCars(carNames, movableStrategy);
        return new RacingGame(racingCars, selectWinnerStrategy);
    }

    private Snapshot moveRacingCars() {
        racingCars.stream()
                .filter(RacingCar::isMove)
                .forEach(RacingCar::moveForward);
        return createSnapshot();
    }

    private Snapshot createSnapshot() {
        return Snapshot.of(racingCars.stream()
                .map(RacingCar::createRacingResult)
                .collect(Collectors.toList()));
    }

    public List<String> selectWinnerNames() {
        return selectWinnerStrategy.select(racingCars).stream()
                .map(RacingCar::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    public synchronized List<Snapshot> run(final int numberOfAttempts) {
        final List<Snapshot> snapshots = new ArrayList<>(numberOfAttempts);
        for (int i = 0; i < numberOfAttempts; i++) {
            snapshots.add(moveRacingCars());
        }
        return snapshots;
    }
}
