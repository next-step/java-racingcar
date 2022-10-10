package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final RacingCars racingCars;
    private final MovingStrategy movingStrategy;
    private final int gameTurnCount;
    private final RacingGameLogStore racingGameLogStore;

    public RacingGame(List<RacingCar> racingCars, MovingStrategy movingStrategy, int gameTurnCount) {
        this.racingCars = new RacingCars(racingCars);
        this.movingStrategy = movingStrategy;
        this.gameTurnCount = gameTurnCount;
        this.racingGameLogStore = new RacingGameLogStore();
    }

    public void run() {
        for (int i = 0; i < this.gameTurnCount; i++) {
            this.racingCars.getRacingCars()
                           .forEach(racingCar -> racingCar.move(movingStrategy));
            racingGameLogStore.store(this);
        }
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public List<RacingGameLog> getGameLogs() {
        return Collections.unmodifiableList(racingGameLogStore.getLogs());
    }

    public List<RacingCar> getWinners() {
        final int maxDistance = this.racingCars.getMaxDistance();
        return this.racingCars.getRacingCars()
                              .stream()
                              .filter(racingCar -> racingCar.getDistance() == maxDistance)
                              .collect(Collectors.toUnmodifiableList());

    }
}
