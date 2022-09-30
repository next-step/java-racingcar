package racingcar;

import racingcar.strategy.RandomMovingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int gameTurnCount;
    private final RacingGameLogStore racingGameLogStore;

    public RacingGame(List<RacingCar> racingCars, int gameTurnCount) {
        this.racingCars = racingCars;
        this.gameTurnCount = gameTurnCount;
        this.racingGameLogStore = new RacingGameLogStore();
    }

    public void run() {
        for (int i = 0; i < this.gameTurnCount; i++) {
            this.racingCars.forEach(racingCar -> racingCar.move(getRandomMovableStrategy()));
            racingGameLogStore.store(ResultView.getLocationStrings(this.racingCars));
        }

        racingGameLogStore.store(ResultView.getWinnerString(getWinners()));
    }

    private RandomMovingStrategy getRandomMovableStrategy() {
        return new RandomMovingStrategy();
    }

    public List<String> getGameLogs() {
        return Collections.unmodifiableList(racingGameLogStore.getLogs());
    }

    public List<RacingCar> getWinners() {
        final int maxDistance = getMaxDistance();
        return this.racingCars.stream()
                              .filter(racingCar -> racingCar.getDistance() == maxDistance)
                              .collect(Collectors.toUnmodifiableList());

    }

    private int getMaxDistance() {
        int maxDistance = Integer.MIN_VALUE;

        for (RacingCar racingCar : this.racingCars) {
            maxDistance = Math.max(maxDistance, racingCar.getDistance());
        }

        return maxDistance;
    }
}
