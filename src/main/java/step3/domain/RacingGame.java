package step3.domain;

import step3.domain.strategy.MovableStrategy;
import step3.domain.strategy.SelectFarthestDistanceWinnerStrategy;
import step3.domain.strategy.SelectWinnerStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private static final SelectWinnerStrategy DEFAULT_SELECT_WINNER_STRATEGY = new SelectFarthestDistanceWinnerStrategy();
    private final List<Car> cars;
    private final SelectWinnerStrategy selectWinnerStrategy;
    private List<Snapshot> snapshots;

    private RacingGame(final List<Car> cars, final SelectWinnerStrategy selectWinnerStrategy) {
        this.cars = Collections.unmodifiableList(cars);
        this.selectWinnerStrategy = selectWinnerStrategy;
    }

    public static RacingGame of(final List<String> carNames, final MovableStrategy movableStrategy) {
        final List<Car> cars = CarFactory.createCars(carNames, movableStrategy);
        return new RacingGame(cars, DEFAULT_SELECT_WINNER_STRATEGY);
    }

    public static RacingGame of(final List<String> carNames, final MovableStrategy movableStrategy, final SelectWinnerStrategy selectWinnerStrategy) {
        final List<Car> cars = CarFactory.createCars(carNames, movableStrategy);
        return new RacingGame(cars, selectWinnerStrategy);
    }

    private Snapshot moveRacingCars() {
        cars.stream()
                .filter(Car::isMove)
                .forEach(Car::moveForward);
        return createSnapshot();
    }

    private Snapshot createSnapshot() {
        return Snapshot.of(cars.stream()
                .map(Car::createRacingResult)
                .collect(Collectors.toList()));
    }

    public List<String> selectWinnerNames() {
        return selectWinnerStrategy.select(cars).stream()
                .map(Car::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    public synchronized void run(final int times) {
        snapshots = new ArrayList<>(times);
        for (int i = 0; i < times; i++) {
            snapshots.add(moveRacingCars());
        }
    }
    
    public List<Snapshot> extractSnapshots() {
        return snapshots;
    }
}
