package racingcar;

import java.util.List;

public class GameManager {

    private final RuleStrategy ruleStrategy;

    public GameManager(RuleStrategy ruleStrategy) {
        this.ruleStrategy = ruleStrategy;
    }

    public Records play(List<String> carNames, int gameRoundNum) {
        Cars cars = readyCars(carNames);
        GameRounds gameRounds = new GameRounds(gameRoundNum);

        while (!gameRounds.isGameEnd()) {
            cars.move();
            gameRounds.endRound();
            gameRounds.keepRecord(cars);
        }

        return gameRounds.getRecords();
    }

    private Cars readyCars(List<String> carNames) {
        return new Cars(carNames, ruleStrategy);
    }
}
