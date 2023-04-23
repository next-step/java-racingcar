package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.GameResult;
import racing.domain.RoundResult;
import racing.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            gameResult.addRound1(cars.race(racingRule));
        }
        return gameResult;
    }
}
