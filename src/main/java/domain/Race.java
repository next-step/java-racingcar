package domain;

import java.util.List;

public class Race {

    private final MoveStrategy moveStrategy;
    private final int totalRounds;
    private final Cars cars;
    private int currentRound = 0;

    public Race(GameSettings settings) {
        this(settings, new RandomMoveStrategy());
    }

    public Race(GameSettings settings, MoveStrategy moveStrategy) {
        this.totalRounds = settings.getRoundCount();
        this.cars = Cars.fromNames(settings.getCarNames());
        this.moveStrategy = moveStrategy;
    }

    public List<CarStatus> getCarStatuses() {
        return cars.getCarStatuses();
    }

    public void runRound() {
        validateRaceInProgress();
        cars.moveAll(moveStrategy);
        currentRound++;
    }

    public boolean isRaceInProgress() {
        return currentRound < totalRounds;
    }

    private void validateRaceInProgress() {
        if (!isRaceInProgress()) {
            throw new IllegalStateException("Race has already finished");
        }
    }

    private void validateRaceFinished() {
        if (isRaceInProgress()) {
            throw new IllegalStateException("Race is still in progress");
        }
    }

    public List<CarStatus> getWinners() {
        validateRaceFinished();
        return cars.findWinners();
    }
}
