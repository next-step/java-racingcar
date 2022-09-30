package racingcar;

import racingcar.strategy.RandomMovingStrategy;

import java.util.Collections;
import java.util.List;

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
    }

    private RandomMovingStrategy getRandomMovableStrategy() {
        return new RandomMovingStrategy();
    }

    public List<String> getGameLogs() {
        return Collections.unmodifiableList(racingGameLogStore.getLogs());
    }
}
