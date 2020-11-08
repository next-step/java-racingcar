package racingcar;

import java.util.List;

public class GameManager {

    private final RuleStrategy ruleStrategy;
    private final WinStrategy winStrategy;

    public GameManager(RuleStrategy ruleStrategy, WinStrategy winStrategy) {
        this.ruleStrategy = ruleStrategy;
        this.winStrategy = winStrategy;
    }

    public GameResult play(List<String> carNames, int gameRoundNum) {
        Cars cars = new Cars(carNames);

        RoundRecords roundRecords = race(cars, gameRoundNum);

        Winners winners = winStrategy.decideWinners(roundRecords);

        return new GameResult(winners, roundRecords);
    }

    private RoundRecords race(Cars cars, int gameRoundNum) {
        GameRounds gameRounds = new GameRounds(gameRoundNum);

        while (!gameRounds.isGameEnd()) {
            cars.move(ruleStrategy);
            gameRounds.endRound();
            gameRounds.keepRecord(cars);
        }

        return gameRounds.getRecords();
    }
}
