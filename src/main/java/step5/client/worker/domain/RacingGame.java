package step5.client.worker.domain;

import step5.client.worker.domain.strategy.MovableStrategy;
import step5.client.worker.domain.strategy.SelectFarthestDistanceWinnerStrategy;
import step5.client.worker.domain.strategy.SelectWinnerStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final SelectWinnerStrategy DEFAULT_SELECT_WINNER_STRATEGY = new SelectFarthestDistanceWinnerStrategy();
    private final List<Car> cars;
    private final SelectWinnerStrategy selectWinnerStrategy;
    private volatile boolean finished = false;
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

    private void moveCars() {
        cars.stream()
                .filter(Car::isMove)
                .forEach(Car::moveForward);
    }

    private Snapshot createSnapshot() {
        final List<Car> clonedCars = cars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
        return Snapshot.of(Collections.unmodifiableList(clonedCars));
    }

    public List<String> selectWinnerNames() {
        if (isNotFinished()) {
            return Collections.emptyList();
        }
        
        return selectWinnerStrategy.select(cars).stream()
                .map(Car::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    public synchronized void run(final int times) {
        if (isFinished()) {
            return;
        }

        initSnapShots(times);

        for (int i = 0; i < times; i++) {
            moveCars();
            saveSnapshot();
        }

        changeToFinished();
    }

    private void initSnapShots(final int times) {
        snapshots = new ArrayList<>(times);
    }

    private void saveSnapshot() {
        snapshots.add(createSnapshot());
    }

    public List<Snapshot> extractSnapshots() {
        if (isNotFinished()) {
            return Collections.emptyList();
        }
        return snapshots;
    }

    private boolean isNotFinished() {
        return !isFinished();
    }

    private boolean isFinished() {
        return finished;
    }

    private void changeToFinished() {
        this.finished = true;
    }
}
