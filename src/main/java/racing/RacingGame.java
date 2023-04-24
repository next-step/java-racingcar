package racing;

import racing.domain.Cars;
import racing.domain.GameResult;
import racing.rule.RacingRule;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final RacingRule racingRule;

    public RacingGame(List<String> carNames, RacingRule racingRule) {
        this.cars = Cars.of(carNames);
        this.racingRule = racingRule;
    }

    public GameResult start(int opportunity) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < opportunity; i++) {
            gameResult.addRound(cars.race(racingRule));
        }
        return gameResult;
    }
}
